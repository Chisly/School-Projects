import cv2 as cv

def main():
    size = (320, 320)

    img = cv.imread('SmolKitty.jpg')
    resized = cv.resize(img, size)
    gray_image = cv.cvtColor(resized, cv.COLOR_BGR2GRAY)

    cv.imshow("Original", img)
    cv.imshow("Modified", gray_image)
    cv.waitKey(0)
    cv.destroyAllWindows()


if __name__ == "__main__":
    main()
