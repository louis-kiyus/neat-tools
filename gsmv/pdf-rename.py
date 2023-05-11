import PyPDF2
import os
import sys
import argparse

parser = argparse.ArgumentParser(description='Process some arguments')
# the * means that there can be any number of arguments
parser.add_argument('filepaths', metavar='filepath',
                    type=str, nargs='*', help='input file\'s paths')
parser.add_argument('-i', '--index', type=int, default=0,
                    help='Line number in PDF to be used as filename')
args = parser.parse_args()

if len(args.filepaths) == 0:
    print("No filepaths provided")
    sys.exit(1)
for original_dir in args.filepaths:
    print("Filepath:", original_dir)

    dir_parts = original_dir.split("/")
    # excludes the last element, which is the original filename
    # the [''] at the end is to add a trailing slash (since we need to add the filename later)
    # -> works because we're adding an empty string to the list
    new_dir = "/".join(dir_parts[:-1] + [''])

    pdfFileObj = open(original_dir, 'rb')
    pdfReader = PyPDF2.PdfReader(pdfFileObj)
    pageObj = pdfReader.pages[0]
    new_filename = pageObj.extract_text().splitlines()[args.index] + ".pdf"
    new_dir += new_filename
    print()
    print("New Filename:", new_filename)
    os.system("mv " + "\"" + original_dir +
              "\"" + " " + "\"" + new_dir + "\"")
