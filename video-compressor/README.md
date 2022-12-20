## Overview

## How to run

### Optional flags
| Flag | Description                                                                                                                                         |
|------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| `-q` | Specifies the quality of the compressed videos. Higher value results in lower quality videos with smaller file sizes. Recommended range is `20-30`. |
| `-d` | Specifies the file path where the compressed videos will be saved. Remember to include `/` at the end of the file path.                             |
| `-s` | Specifies the file path of the videos to be compressed. Remember to include `/` at the end of the file path.                                        |
| `-t` | Specifies the type of the videos to be compressed. Default is `mp4`.                                                                                |

### Example command
`bash compress.sh -s "/Volumes/LOUIS's Drive/Purdue/" -d "/Volumes/PURDUE/" -q 25`
The above command compresses all the MP4 videos present in the `Purdue` directory residing in `LOUIS's Drive` and sends the compressed videos to a volume named `PURDUE`. The quality of the output video is set to `25`.

###### Original Publish Date: December 19, 2022