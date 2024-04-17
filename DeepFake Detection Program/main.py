import matplotlib.pyplot as plt
import pathlib
import tensorflow as tf
from tensorflow.python.keras import layers
from tensorflow.python.keras.models import Sequential
import numpy as np

#Creates/Loads DataSet for keras
#Batch size is the amount of images in model runtime (different images every time)
#Need to have a good amount of batch size
#so there isn't any Overfitting or Underfitting
#If overfit, model cannot properly predict on new datasets. Training set may be too small
#If underfit, model cannot find a pattern. Training set may be too simple
train_ds = tf.keras.utils.image_dataset_from_directory(
    pathlib.Path('Data/Train'),
    validation_split=0.2,
    subset = "training",
    seed = 123,
    image_size = (180, 180),
    batch_size = 16
)

val_ds = tf.keras.utils.image_dataset_from_directory(
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
AUTOTUNE = tf.data.AUTOTUNE

train_ds = train_ds.cache().shuffle(1000).prefetch(buffer_size=AUTOTUNE)
val_ds = val_ds.cache().prefetch(buffer_size=AUTOTUNE)

#Changes data to a format that the model can understand
normalization_layer = tf.keras.layers.Rescaling(1./255)

normalized_ds = train_ds.map(lambda x, y: (normalization_layer(x), y))
image_batch, labels_batch = next(iter(normalized_ds))
first_image = image_batch[0]

#Creates the model with these params
class_names = ['Fake', 'Real']
num_classes = len(class_names)

model = tf.keras.models.Sequential([
    tf.keras.layers.Input(shape=(180, 180, 3)),
    tf.keras.layers.Rescaling(1./255),
    tf.keras.layers.Conv2D(16, 3, padding='same', activation='relu'),
    tf.keras.layers.MaxPooling2D(),
    tf.keras.layers.Conv2D(32, 3, padding='same', activation='relu'),
    tf.keras.layers.MaxPooling2D(),
    tf.keras.layers.Conv2D(64, 3, padding='same', activation='relu'),
    tf.keras.layers.MaxPooling2D(),
    tf.keras.layers.Flatten(),
    tf.keras.layers.Dense(128, activation='relu'),
    tf.keras.layers.Dense(num_classes)
])

#Compiles the model
model.compile(optimizer = 'adam',
              loss = tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
              metrics=['accuracy'])

#Goes through the dataset epoch # times
#More epochs does not mean better as it may overfit the model
#Too few epochs may not let the model find a pattern
epochs=6
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
#Fake Image
input_image = pathlib.Path('Data/Test/Fake/00F8LKY6JC.jpg')

img = tf.keras.utils.load_img(
    input_image, target_size=(180, 180)
)

img_array = tf.keras.utils.img_to_array(img)
img_array = tf.expand_dims(img_array, 0) # Create a batch

predictions = model.predict(img_array)
score = tf.nn.softmax(predictions[0])

print(
    "There is a {:.2f} percent chance that this image is {}."
    .format(100 * np.max(score), class_names[np.argmax(score)])
)

#Real Image
input_image = pathlib.Path('Data/Test/Real/00001.jpg')

img = tf.keras.utils.load_img(
    input_image, target_size=(180, 180)
)

img_array = tf.keras.utils.img_to_array(img)
img_array = tf.expand_dims(img_array, 0) # Create a batch

predictions = model.predict(img_array)
score = tf.nn.softmax(predictions[0])

print(
    "There is a {:.2f} percent chance that this image is {}."
    .format(100 * np.max(score), class_names[np.argmax(score)])
)

#Ignore this
'''
trdata = tf.keras.preprocessing.image.ImageDataGenerator()
traindata = trdata.flow_from_directory(directory="Real\Train",target_size=(224,224))
tsdata = tf.keras.preprocessing.image.ImageDataGenerator()
valdata = tsdata.flow_from_directory(directory="Real\Valid", target_size=(224,224))

model = Sequential()
model.add(Conv2D(input_shape=(224,224,3),filters=64,kernel_size=(3,3),padding="same", activation="relu"))
model.add(Conv2D(filters=64,kernel_size=(3,3),padding="same", activation="relu"))
model.add(MaxPool2D(pool_size=(2,2),strides=(2,2)))
model.add(Conv2D(filters=128, kernel_size=(3,3), padding="same", activation="relu"))
model.add(Conv2D(filters=128, kernel_size=(3,3), padding="same", activation="relu"))
model.add(MaxPool2D(pool_size=(2,2),strides=(2,2)))
model.add(Conv2D(filters=256, kernel_size=(3,3), padding="same", activation="relu"))
model.add(Conv2D(filters=256, kernel_size=(3,3), padding="same", activation="relu"))
model.add(Conv2D(filters=256, kernel_size=(3,3), padding="same", activation="relu"))
model.add(MaxPool2D(pool_size=(2,2),strides=(2,2)))
model.add(Conv2D(filters=512, kernel_size=(3,3), padding="same", activation="relu"))
model.add(Conv2D(filters=512, kernel_size=(3,3), padding="same", activation="relu"))
model.add(Conv2D(filters=512, kernel_size=(3,3), padding="same", activation="relu"))
model.add(MaxPool2D(pool_size=(2,2),strides=(2,2)))
model.add(Conv2D(filters=512, kernel_size=(3,3), padding="same", activation="relu"))
model.add(Conv2D(filters=512, kernel_size=(3,3), padding="same", activation="relu"))
model.add(Conv2D(filters=512, kernel_size=(3,3), padding="same", activation="relu"))
model.add(MaxPool2D(pool_size=(2,2),strides=(2,2)))

model.add(Flatten())
model.add(Dense(units=4096,activation="relu"))
model.add(Dense(units=4096,activation="relu"))
model.add(Dense(units=2, activation="softmax"))


opt = Adam(lr=0.001)
model.compile(optimizer=opt, loss=keras.losses.categorical_crossentropy, metrics=['accuracy'])
model.summary() '''