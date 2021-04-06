# Python script to automate testing varying dataset sizes

import os
import random as r

file = open("data/oklistraw.txt", "r")
lines = file.readlines()


def randomLines(n):
    linesList = [i for i in range(n-1, -1, -1)]
    r.shuffle(linesList)
    return linesList


#randomLines(10)
for n in range(1,11):
    datasetSize = n*500
    subsetLinePos = randomLines(datasetSize)
    #print(subsetLinePos)
    varyingfile = open("data/oklist.txt", "w")
    for i in range(datasetSize):
        varyingfile.write(lines[subsetLinePos[i]])
    
    #print(datasetSize)
