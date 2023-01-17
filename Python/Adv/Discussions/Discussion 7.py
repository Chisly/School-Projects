from bs4 import BeautifulSoup
import urllib.request
import string
import json

url = urllib.request.urlopen('https://www.rottentomatoes.com/top/')

soup = BeautifulSoup(url, 'html.parser')

para = soup.find_all('script')[2].text.strip()

data = json.loads(para)

info = []

print(data['@graph'][0]['name'])

for item in data['@graph'][0]['itemListElement']:
    temp1 = item['url']
    temp2 = temp1.rsplit('/', 2)[-2]
    temp3 = temp2.replace("_", " ")
    temp4 = string.capwords(temp3)
    info.append({
        item['position']+1: temp4
    })

print(*info, sep = '\n')
