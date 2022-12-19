No `/` allowed in filename

### Prerequsites
`ffmpeg` needs to be installed. This can be installed through `brew install ffmpeg` on Macs and `sudo apt install ffmpeg` on Linux machines

`-i` specifies the initial number of the output files

For example `-i 2` will result in an output filename of `2. filename.mp4`

`-d` specifies the destination of the output files

Note: Remember to include slash (`/`) at the end of the filepath

## Example command
`bash download_videos.sh -i 38 -d ./additional\ videos/`
This command will create file names that start from `38. ` and will place all the output videos into a directory called `addition videos` that is located in the current directory. 
