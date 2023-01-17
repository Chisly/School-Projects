from bs4 import BeautifulSoup
import urllib.request

def findInfo():
    user = input("Name a cat breed: ")

    html = urllib.request.urlopen('https://en.wikipedia.org/wiki/%s_cat' % user)

    soup = BeautifulSoup(html, 'html.parser')

    para = soup.select('div > p')[0].get_text(strip=False)

    try:
        first = para.split()[0]
        if first == 'The':
            print(soup.select('div > p')[0].get_text(strip=False))
        else:
            print(soup.select('div > p')[1].get_text(strip=False))
    except IndexError:
        print(soup.select('div > p')[1].get_text(strip=False))


def main():
    findInfo()


if __name__ == "__main__":
    main()
