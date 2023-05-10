# PDF Renamer

## Abstract

This script renames a PDF file specified in its first argument by extracting the title from the PDF's first line and using it as the new filename. The script has been tested with PDFs that are graded on Gradescope.

## Instructions

To run, simply enter:

```
python3 pdf-rename.py "full-path-here-enclosed-with-quotation-mark.pdf"
```

As an example, here's an example of invoking a script named `submission-13.pdf`: `python3 pdf-rename.py "~/Documents/submission-13.pdf"`. If you're on a Mac, you can simply drag-and-drop the file into your Terminal.

## Aliasing gsmv

For your convenience, you can make an alias out of this command. Add the following to your `~/.zshrc` or `~/.bashrc` file:

```
alias gsmv= "python3 full-path-to-where-you-saved-this-script"
```

Then, you will be able to invoke this script anywhere by simply calling `gsmv "full-path-here-enclosed-with-quotation-mark.pdf"`.

P.S. `gsmv` stands for "Gradescope mv"
