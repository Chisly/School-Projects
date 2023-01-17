from bs4 import BeautifulSoup
import urllib.request
import string
import json
import re

def main():
    #The url is is grabbed and parsed with the first 2 lines of code below
    url = urllib.request.urlopen('https://www.rottentomatoes.com/top/')

    soup = BeautifulSoup(url, 'html.parser')

    #The code directly below searches for the third instance of <script> in the page source
    #.strip removes any leading whitespace and .text removes the <script>
    para = soup.find_all('script')[2].text.strip()

    #This code parses the JSON string acquired with the code above
    data = json.loads(para)

    #gex is a regex that looks to see if the strings begin with https://www.rottentomatoes.com
    gex = re.compile("(http|https):\/\/(www.rottentomatoes.com)\/m\/.*")

    info = {}

    #This prints the list's name that is displayed on the website
    print(data['@graph'][0]['name'])

    #Here we iterate through a list that is on the page source that contains the information
    #we need, which is the movie name and their position in the ranking
    for item in data['@graph'][0]['itemListElement']:

        #Here we use regex to see if the string we got from the website matches our
        #condition from before
        if(re.search(gex, item['url'])):

            #temp1-4 just cleans up the Movie name. It removes the url format it's in
            #as well as capitalize letters and remove underscores
            temp1 = item['url']
            temp2 = temp1.rsplit('/', 2)[-2]
            temp3 = temp2.replace("_", " ")
            temp4 = string.capwords(temp3)

            #Here a new key and value is inputted into the dictionary made before
            info["Number " + str(item['position']+1)] = temp4

        #if for what ever reason the url doesn't match up, it skips it
        else:
            pass

    #Prints dictionary
    for key, value in info.items():
        print(key, ':', value)

    choice = input("Do you want to save this data? (Y or N) ")
    
    #Asks if user wants to save dictionary to a file
    if(choice.lower() == 'y'):

        #Creates txt file if there isnt already one named as such and transfers over data from dict
        with open('Saved_Dict.txt', 'w') as f:

            #Writes the list's name according to website and a header for the columns
            f.write(data['@graph'][0]['name']+"\n\n"
            + "Ranking # | Movie Name\n------------------------------------\n")

            #Writes dictionary to file similar to how we printed it earlier
            for key, value in info.items():
                f.write("%s: %s\n" % (key, value))
            f.close()
        print("Saving Data.")
    else:
        print("Nothing Saved.")

if __name__ == "__main__":
    main()
