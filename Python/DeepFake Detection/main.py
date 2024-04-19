import matplotlib.pyplot as plt
import pathlib
import tensorflow
import numpy

#Creates/Loads DataSet for keras
#Batch size is the amount of images in model runtime (different images every time)
#Need to have a good amount of batch size
#so there isn't any Overfitting or Underfitting
#If overfit, model cannot properly predict on new datasets. Training set may be too small
#If underfit, model cannot find a pattern. Training set may be too simple
train_ds = tensorflow.keras.utils.image_dataset_from_directory(
    pathlib.Path('Data/Train'),
    validation_split=0.2,
    subset = "training",
    seed = 123,
    image_size = (180, 180),
    batch_size = 16
)

val_ds = tensorflow.keras.utils.image_dataset_from_directory(
    pathlib.Path('Data/Valid'),
    validation_split=0.2,
    subset = "validation",
    seed = 123,
    image_size = (180, 180),
    batch_size = 16
)

#Modifies and sets DataSet
#For example, train_ds shuffles the Training DataSet
#Sets amount of VRAM and other resources model uses to run
AUTOTUNE = tensorflow.data.AUTOTUNE

train_ds = train_ds.cache().shuffle(1000).prefetch(buffer_size=AUTOTUNE)
val_ds = val_ds.cache().prefetch(buffer_size=AUTOTUNE)

#Changes data to a format that the model can understand
normalization_layer = tensorflow.keras.layers.Rescaling(1./255)

normalized_ds = train_ds.map(lambda x, y: (normalization_layer(x), y))
image_batch, labels_batch = next(iter(normalized_ds))
first_image = image_batch[0]

#Creates the model with these params
classifications = ['Fake', 'Real']
classAmounts = len(classifications)

model = tensorflow.keras.models.Sequential([
    tensorflow.keras.layers.Input(shape=(180, 180, 3)),
    tensorflow.keras.layers.Rescaling(1./255),
    tensorflow.keras.layers.Conv2D(16, 3, padding='same', activation='relu'),
    tensorflow.keras.layers.MaxPooling2D(),
    tensorflow.keras.layers.Conv2D(32, 3, padding='same', activation='relu'),
    tensorflow.keras.layers.MaxPooling2D(),
    tensorflow.keras.layers.Conv2D(64, 3, padding='same', activation='relu'),
    tensorflow.keras.layers.MaxPooling2D(),
    tensorflow.keras.layers.Flatten(),
    tensorflow.keras.layers.Dense(128, activation='relu'),
    tensorflow.keras.layers.Dense(classAmounts)
])

#Compiles the model
model.compile(optimizer = 'adam',
              loss = tensorflow.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
              metrics=['accuracy'])

#Goes through the dataset epoch # times
#More epochs does not mean better as it may overfit the model
#Too few epochs may not let the model find a pattern
epochs=4
history = model.fit(
  train_ds,
  validation_data=val_ds,
  epochs=epochs
)

#Here down to plt.show() prints data accuracy
#We could delete this, mostly used for debugging
#Val accuracy, how well the model performed on unseen data set
#Val loss # of error between prediction and actual output on data set not seen
#Training val and accuracy is same thing but on training set
acc = history.history['accuracy']
val_acc = history.history['val_accuracy']

loss = history.history['loss']
val_loss = history.history['val_loss']

epochs_range = range(epochs)

plt.figure(figsize=(8, 8))
plt.subplot(1, 2, 1)
plt.plot(epochs_range, acc, label='Training Accuracy')
plt.plot(epochs_range, val_acc, label='Validation Accuracy')
plt.legend(loc='lower right')
plt.title('Training and Validation Accuracy')

plt.subplot(1, 2, 2)
plt.plot(epochs_range, loss, label='Training Loss')
plt.plot(epochs_range, val_loss, label='Validation Loss')
plt.legend(loc='upper right')
plt.title('Training and Validation Loss')
plt.show()

#Here down sets up an image to predict
while(True):
    try:
        dir = input("Enter path to image.\nEx: Path/To/Img.jpg\n")
        if dir == "stop":
            break

        input_image = pathlib.Path(dir)
        img = tensorflow.keras.utils.load_img(
            input_image, target_size=(180, 180)
        )

        img_array = tensorflow.keras.utils.img_to_array(img)
        img_array = tensorflow.expand_dims(img_array, 0)

        guesses = model.predict(img_array)
        result = tensorflow.nn.softmax(guesses[0])

        print(
            "There is a {:.2f} percent chance that this image is {}."
            .format(100 * numpy.max(result), classifications[numpy.argmax(result)])
        )

    except FileNotFoundError:
        print("File not found.\n")