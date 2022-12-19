OLDIFS=$IFS
initialNum=0
directory="./"
while getopts i:d: flag
do
  case "${flag}" in
    i) initialNum=${OPTARG};;
    d) directory=${OPTARG};;
  esac
done
File="video_links.txt"
Filenames="video_names.txt"
IFS=$'\n' # needed so that for loop will parse by newline; otherwise it will parse by the spaces
Lines=($(for link in $(cat $File);do echo $link;done)) # creates an array for each line in the first file
Lines2=($(for filename in $(cat $Filenames);do echo "${filename// /_}";done))  # {parameter/pattern/replacement}; over here the double slash causes all spaces to be replaced with underscore instead of just the first occurence
for i in "${!Lines[@]}" # kinda like Lines2.length in java
do
  ffmpeg -i "${Lines[i]}" -bsf:a aac_adtstoasc -vcodec copy -c copy -crf 50 "${directory}$(($i + $initialNum)). ${Lines2[i]}".mp4
done
IFS=$OLDIFS # restore IFS to original
