# BASH-OS
This program is a BASH-like operating system written in Java. 

## How to use BASH-OS
To run the progra, open a Java IDE such as eclipse (https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers) or the IDE of your choice. 

Compile and run all five files (BashTerminal.java, DirectoryNode.java, DirectoryTree.java, FullDirectoryException.java, NotADirectoryException) together. This will prompt the user for inputs.
The inputs possible in this OS are as follows:
```
pwd : Printworking directory name.

ls : Print working directory subtree.

ls -r : Print directory tree up to current directory.

ls -s : Print files in current directory by order of file size (decreasing)

Exit : Exit program

cd {directoryName} : Move cursor to a different directory with the name {directoryName}. Target directory must be within current directory.

cd / : move cursor to root.

mkdir {directoryName} : Make a directory with name {directoryName}. Directory will appear in current directory.

touch {fileName} : Make a file with name {fileName} and add it to the current directory.

rm {directoryOrFileName} : Remove file or directory with name {directoryOrFileName}. 

mv {directoryOrFileName} : Move all files and directories to directory with name {directoryOrFileName}.
