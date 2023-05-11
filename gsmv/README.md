# PDF Renamer

## Abstract

This script renames PDF file(s) by extracting the title from the PDF's first line (modifiable by the `-i` flag) and using it as the new filename. The script has been specifically tested with PDFs that are graded on Gradescope and can be used on any other PDFs.

## Dependencies

1. `PyPDF2`. You can check for its availability by the following command:

```
pip3 install PyPDF2
```

If your computer does not have `PyPDF2` installed, the above command will automatically install it for you.

## Instructions

To run, simply enter:

```
python3 pdf-rename.py "full-path-here-enclosed-with-quotation-mark.pdf"
```

As an example, here's an example of invoking a script named `submission-13.pdf`: `python3 pdf-rename.py "~/Documents/submission-13.pdf"`. If you're on a Mac, you can simply drag-and-drop the file into your Terminal.

You can include an infinite number of PDFs in the command. For example:

```
python3 pdf-rename.py "pdf_1.pdf" "pdf_2.pdf"
```

## Additional flag

| Flag   | Description                                                                                                                                 |
| ------ | ------------------------------------------------------------------------------------------------------------------------------------------- |
| `-i` | This flag is used to specify the line number in the PDF that will be used as the filename. By default, we will use the first line (line 0). |

## Aliasing gsmv

For your convenience, you can make an alias out of this command. Add the following to your `~/.zshrc` or `~/.bashrc` file:

```
alias gsmv= "python3 full-path-to-where-you-saved-this-script"
```

Then, you will be able to invoke this script anywhere by simply calling `gsmv "full-path-here-enclosed-with-quotation-mark.pdf"`.

P.S. `gsmv` stands for "Gradescope mv"
