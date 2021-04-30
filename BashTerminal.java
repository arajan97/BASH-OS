import java.util.Scanner;

public class BashTerminal {
	public static void main(String[] args) throws NotADirectoryException, IllegalArgumentException, FullDirectoryException{
		String com = "";
		System.out.println("Starting Bash Terminal.");
		Scanner scan = new Scanner(System.in);
		DirectoryTree tree = new DirectoryTree();
		while(true){
			System.out.println("[ananthRajan@host]: $ ");
			com = scan.nextLine();
			com.trim();
			if(com.equalsIgnoreCase("pwd")){
				System.out.println(tree.presentWorkingDirectory());
			}
			else if(com.equalsIgnoreCase("ls")){				
				System.out.println(tree.listDirectory());
			}
			//there is no difference between -r and -R
			else if(com.equalsIgnoreCase("ls -r")){
				tree.printDirectoryTree(tree.getCursor(), 0);
			}
			//sort current directory by size
			else if(com.equalsIgnoreCase("ls -s")){
				System.out.println(tree.listDirectorySize());
			}
			
			else if(com.equalsIgnoreCase("Exit")){
				System.out.println("Program terminating normally!");
				break;
			}
			String com1 = " ";
			String com2  = " ";
			if(com.contains(" ")){
				String[] arr = com.split(" ");
				com1 = arr[0];
				com2 = arr[1];
			}			
			if(com1.equalsIgnoreCase("cd")){
				if(com2.equalsIgnoreCase("/")){
					tree.resetCursor();
				}
				else{
					try{
					tree.changeDirectory(com2);
					}
					catch(NotADirectoryException e){}
				}
			}
			else if(com1.equalsIgnoreCase("mkdir")){
				try{
					tree.makeDirectory(com2);
				}
				catch(FullDirectoryException e){}
			}
			else if(com1.equalsIgnoreCase("touch")){
				try{
				tree.makeFile(com2);
				}
				catch(FullDirectoryException e){}
			}
			else if(com1.equalsIgnoreCase("rm")){
				tree.remove(com2);
			}
			else if(com1.equalsIgnoreCase("mv")){
				DirectoryNode temp = tree.getCursor();
				tree.resetCursor();
				tree.changeDirectory(com2);
				tree.moveFilesSync(temp, tree.getCursor());

			}
		}
		scan.close();
	}
}
