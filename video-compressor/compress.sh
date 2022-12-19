quality=36
while getopts q: flag
do
  case "${flag}" in
    q) quality=${OPTARG};;
  esac
done
for file in ./*.mp4
do
  ffmpeg -i "$file" -vcodec libx265 -crf $quality "${file%\.*}"-compressed.mp4
done

