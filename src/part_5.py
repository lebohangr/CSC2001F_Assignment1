#!/bin/python3

import subprocess
import random


def create_random_dataset(load_shedding_file, random_file):

    lines = list()
    written_lines = list()

    with open(load_shedding_file, "r") as f:

        lines = f.readlines();


    with open(random_file, "w") as f:

        count = 0;
        length = len(lines);

        for i in range(length):

            random_data = random.randint(0,length-1-i);

            f.write(lines[random_data])
            lines.pop(random_data)

    #while ( count < len(lines) ):

        #random_data = random.randint(0,length-1);

        #if lines[random_data] in written_lines:

            #print(lines[random_data])

        #else:

            #written_lines.append(written_lines);
            #f.write(lines[random_data]);

            #count+=1

    print("All done bra");
    #lines = f.readlines();
    #length = len(lines);
    #n_values = range(int(length / 10), length, int(length / 10));
    #random_data = 0

    #for i in n_values:

        #for j in range(i):

            #random_data = random.randint(0,length-1)

            #subprocess.call(["java", "LSBSTApp", lines[random_data].split(" ")[0]] );
            #subprocess.call(["java", "LSArrayApp", lines[random_data].split(" ")[0]] );

            #print()

    #print(len(f.readlines()))
    #for i in f.readlines():

        #print(i, end="")

def create_n_files(random_file):

    lines = list()
    with open(random_file, "r") as f:

        lines = f.readlines()


    for i in range(297, 2970, 297):

        with open("../data/random_file_"+str(i)+".txt", "w") as f:

            for j in range(0,i):

                f.write(lines[j]);

        

def run_lsbst():

    lines = list()

    for i in range(270, 2970, 270):

        with open("../data/random_file_"+str(i)+".txt", "r") as f:

            lines = f.readlines()

            for j in lines:

                subprocess.call(["java", "-cp", "../bin", "LSBSTApp", j.split(" ")[0]] );
                #subprocess.call(["java", "LSArrayApp", lines[random_data].split(" ")[0]] );
                

    with open("../data/random_data.txt", "r") as f:

        lines = f.readlines()

        for j in lines:

            subprocess.call(["java", "-cp", "../bin", "LSBSTApp", j.split(" ")[0]] );

if __name__ == "__main__":
    #create_random_dataset("../data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt", "../data/random_data.txt");
    create_n_files("../data/random_data.txt");

    #run_lsbst()
