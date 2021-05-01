# BASH-OS
This program is a BASH-like operating system written in Java. 

## How to use BASH-OS
To run the progra, open a Java IDE such as eclipse (https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers) or the IDE of your choice. 

Compile and run all five files (BashTerminal.java, DirectoryNode.java, DirectoryTree.java, FullDirectoryException.java, NotADirectoryException) together. This will prompt the user for inputs.
The inputs possible in this OS are as follows:
```
pwd : Print working directory name.

ls : Print working directory subtree.

ls -r : Print directory tree up to current directory in hierarchy format. Directories will be denoted with '|-' and files are denoted with '-'

ls -s : Print files in current directory by order of file size (decreasing)

Exit : Exit program

cd {directoryName} : Move cursor to a different directory with the name {directoryName}. Target directory must be within current directory.

cd / : move cursor to root.

mkdir {directoryName} : Make a directory with name {directoryName}. Directory will appear in current directory.

touch {fileName} : Make a file with name {fileName} and add it to the current directory.

rm {directoryOrFileName} : Remove file or directory with name {directoryOrFileName}. 

mv {directoryPath} : Move all files and directories to directory with name {directoryPath}. {directoryPath} should have the syntax directoryName/directoryName2/etc. Disregard root in path.
```
These commands allow you to create and move through directories, create and delete files, list directories and files in a hierarchy or in a basic list, and move files and directories from one location to another. 

##Functionality

The operating system is implemented using a tree, with each node in the tree having up to three children (left, middle, and right). This means that any given directory (including root) can only have three directories or files as children. Those children can then have up to three children of their own, assuming that child is a directory. This implementation can be changed to allow unlimited child directories. Files cannot have children. When creating a file, the fileSize is set randomly, but this functionality can be changed easily. ***ls -s*** is useful for visualizing a directory sorted by file size. 

Because ***rm*** removes a child of the users choosing, the ***left, middle, right*** architecture is updated automatically in the background to improve user experience. Files and directories will fill up the left and middle child nodes before filling the right child node. Removing a parent will also remove all children. 

The ***mv*** command moves files from one directory to another. Although finding directory {directoryName} takes O(depth{directoryName}) time, moving the files is accomplished in O(1) time. The cursor will point to the new directory.

Example of ***mv*** and ***ls -r***:
```
[ananthRajan@host]: $ 
ls -r

        |- root
                |- FirstFolder
                        |- storage
                                - myfile
                                - mydata
                |- SecondFolder
                        |- important
                        |- notImportant
                |- ThirdFolder
[ananthRajan@host]: $
cd FirstFolder
[ananthRajan@host]: $ 
cd storage
[ananthRajan@host]: $ 
mv SecondFolder/notImportant
[ananthRajan@host]: $ 
cd /
[ananthRajan@host]: $ 
ls -r

        |- root
                |- FirstFolder
                        |- storage      
                |- SecondFolder
                        |- important    
                        |- notImportant 
                                - myfile
                                - mydata
                |- ThirdFolder

```




