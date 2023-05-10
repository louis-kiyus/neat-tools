import PyPDF2
import os
import sys

# Select all pdf files in the current directory

original_dir = sys.argv[1]

print("Original directory:", original_dir)
dir_parts = original_dir.split("/")
# excludes the last element, which is the original filename
# the [''] at the end is to add a trailing slash (since we need to add the filename later)
# -> works because we're adding an empty string to the list
new_dir = "/".join(dir_parts[:-1] + [''])

pdfFileObj = open(original_dir, 'rb')
pdfReader = PyPDF2.PdfReader(pdfFileObj)
pageObj = pdfReader.pages[0]
new_filename = pageObj.extract_text().splitlines()[0] + ".pdf"
new_dir += new_filename
print()
print("New Filename:", new_filename)
os.system("mv " + "\"" + original_dir +
          "\"" + " " + "\"" + new_dir + "\"")
