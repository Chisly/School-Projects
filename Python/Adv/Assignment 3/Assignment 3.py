import image as cim

#The code resizes the image by about half on both the width and height 
#Then changes the character's color from yellow to blue

def resize(img):
    w = img.getWidth()
    h = img.getHeight()

    newImg = cim.EmptyImage(w // 2, h // 2)

    for row in range(newImg.getHeight()):
        for col in range(newImg.getWidth()):
            oriCol = col * 2
            oriRow = row * 2
            
            oriPixel = img.getPixel(oriCol, oriRow)

            newImg.setPixel(col, row, oriPixel)

    return newImg


def colorSwap(rImg):
    w = rImg.getWidth()
    h = rImg.getHeight()

    finalImg = cim.EmptyImage(w, h)

    for row in range(h):
        for col in range(w):
            oriPixel = rImg.getPixel(col, row)
            newPixel = invertPixel(oriPixel)

            finalImg.setPixel(col, row, newPixel)
            
    return finalImg


def invertPixel(oriPixel):
    newRed = 255 - oriPixel.getRed()
    newBlue = 255 - oriPixel.getBlue()
    newGreen = 255 - oriPixel.getGreen()

    if(newRed >= 100 and newBlue >= 100 and newGreen >= 100):
        return oriPixel
    elif(newRed <= 200 and newBlue <= 200 and newGreen <= 200):
        return oriPixel
    
    newPixel = cim.Pixel(newRed, newGreen, newBlue)
    return newPixel


def printImgs():
    img = cim.FileImage('AlienHominid.png')
    win = cim.ImageWin(img.getWidth(), img.getHeight(), "Original")
    rWin = cim.ImageWin(img.getWidth() // 2, img.getHeight() // 2, "Modified")
    
    rImg = resize(img)
    fImg = colorSwap(rImg)
    fImg.draw(rWin)
    img.draw(win)

    win.exitOnClick()
    rWin.exitOnClick()


def main():
    printImgs()


if __name__ == "__main__":
    main()
