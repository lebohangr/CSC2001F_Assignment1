#!/bin/bash
for i in {297..2976..297}
do
cat Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt | head -n $i >""$i".txt"
done
