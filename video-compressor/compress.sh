quality=36
destination="./"
source="./"
type="mp4"
while getopts q:d:s:t: flag
do
  case "${flag}" in
    q) quality=${OPTARG};;
    d) destination=${OPTARG};;
    s) source=${OPTARG};;
    t) type=${OPTARG};;
  esac
done
for file in ${source}*.${type}
do
  ffmpeg -i "$file" -vcodec libx265 -crf $quality "${destination}${file%\.*}"-compressed.${type}
done

