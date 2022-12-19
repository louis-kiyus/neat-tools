## Prerequsites
`ffmpeg` needs to be installed. This can be installed through `brew install ffmpeg` on Macs and `sudo apt install ffmpeg` on Linux machines

`-i` specifies the initial number of the output files

For example `-i 2` will result in an output filename of `2. filename.mp4`

`-d` specifies the destination of the output files

Note: Remember to include slash (`/`) at the end of the filepath

## How to run
Place all the video links to the `.m3u8` files inside `video_links.txt`. Each link should be inserted in a new line. 
There should not be a new line after the last link.

Place the corresponding video names in the `video_names.txt` file. Each filename should be inserted in a new line. 
There should not be a new line after the last filename. No `/` are allowed in a filename.

### Example command
`bash download_videos.sh -i 38 -d ./additional\ videos/`

This command will create file names that start from `38. ` and will place all the output videos into a directory called `addition videos` that is located in the current directory. 
