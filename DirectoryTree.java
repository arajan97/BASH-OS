import java.util.Random;
public class DirectoryTree {
	private DirectoryNode root = new DirectoryNode();
	private DirectoryNode cursor = new DirectoryNode();
	/**
	 * constructor for DirectoryTree.
	 */
	public DirectoryTree(){
		root.setName("root");
		this.cursor = root;
	}
	/**
	 * @return the root
	 */
	public DirectoryNode getRoot() {
		return root;
	}
	/**
	 * @return the cursor
	 */
	public DirectoryNode getCursor() {
		return cursor;
	}
	/**
	 * @param root the root to set
	 */
	public void setRoot(DirectoryNode root) {
		this.root = root;
	}
	/**
	 * @param cursor the cursor to set
	 */
	public void setCursor(DirectoryNode cursor) {
		this.cursor = cursor;
	}
	/**
	 * sets cursor to root
	 */
	public void resetCursor(){
		cursor = root;
	}
	/**
	 * changes cursor to DirectoryNode with parameter name.
	 * @param name
	 * @throws NotADirectoryException
	 */
	public void changeDirectory(String name) throws NotADirectoryException{
	DirectoryNode temp = new DirectoryNode();
	temp = cursor;
	if(cursor.getLeft() != null){
		if(cursor.getLeft().getName().equalsIgnoreCase(name)){
			if(cursor.getLeft().isFile()){
				throw new NotADirectoryException();
			}
			else{
				cursor = cursor.getLeft();
			}
		}
	}
	if(cursor.getMiddle() != null){
		 if(cursor.getMiddle().getName().equalsIgnoreCase(name)){
			if(cursor.getMiddle().isFile()){
				throw new NotADirectoryException();
			}
			else{
				cursor = cursor.getMiddle();
			}
		}
	}
	if(cursor.getRight() != null){
		if(cursor.getRight().getName().equalsIgnoreCase(name)){
			if(cursor.getRight().isFile()){
				throw new NotADirectoryException();
			}
			else{
				cursor = cursor.getRight();

			}
		}
	}
	if(cursor == temp){
		System.out.println("Directory not found! Please enter another command.");
	}
	}
	/**
	 * returns string representation of the cursors directory.
	 * @return
	 */
	public String presentWorkingDirectory(){
		String a = "";
		a = pWDHelper(cursor);
		return a;
	}
	/**
	 * helper method for presetWorkingDirectory.
	 * @param b
	 * @return
	 */
	private String pWDHelper(DirectoryNode b){
		String result = "";
		if(b.getName().equals("root")){
			return b.getName();
		}
		else{
			result = pWDHelper(b.getParent()) + "/" + b.getName();
		}
		return result;
	}
	/**
	 * lists subdirectory under cursor.
	 * @return
	 */
	public String listDirectory(){
		String z = "";
		if(cursor.getLeft() != null){
			z = cursor.getLeft().getName() + " ";
		}
		if(cursor.getMiddle() != null){
			z = z + cursor.getMiddle().getName() + " ";
		}
		if(cursor.getRight() != null){
			z = z + cursor.getRight().getName() + " ";
		}
		return z;
	}
	/**
	 * sorts the files in a directory by fileSize and prints them along with their fileSize
	 * @return String
	 * returns custom string with files sorted by size
	 */
	public String listDirectorySize(){
		DirectoryNode[] sizeArray = new DirectoryNode[3];		
		
		String z = "";

		if(cursor.getLeft() != null && cursor.getLeft().isFile()){
			sizeArray[0] = cursor.getLeft();
		}
		if(cursor.getMiddle() != null && cursor.getMiddle().isFile()){
			sizeArray[1] = cursor.getMiddle();
		}
		if(cursor.getRight() != null && cursor.getRight().isFile()){
			sizeArray[2] = cursor.getRight();
		}		
		
		if(sizeArray[2] != null){
			if (sizeArray[0].getfileSize() > sizeArray[1].getfileSize() && sizeArray[0].getfileSize() > sizeArray[2].getfileSize()) {
				if (sizeArray[1].getfileSize() > sizeArray[2].getfileSize()){
					z = sizeArray[0].getName() + ": " + sizeArray[0].getfileSize() + ", " + sizeArray[1].getName() + ": " + sizeArray[1].getfileSize() + ", " + sizeArray[2].getName() + ": " + sizeArray[2].getfileSize();	
				}
				else{
					z = sizeArray[0].getName() + ": " + sizeArray[0].getfileSize() + ", " + sizeArray[2].getName() + ": " + sizeArray[2].getfileSize() + ", " + sizeArray[1].getName() + ": " + sizeArray[1].getfileSize();	
				}
			}
			else if (sizeArray[1].getfileSize() > sizeArray[0].getfileSize() && sizeArray[1].getfileSize() > sizeArray[2].getfileSize()){
				if (sizeArray[0].getfileSize() > sizeArray[2].getfileSize()){
					z = sizeArray[1].getName() + ": " + sizeArray[1].getfileSize() + ", " + sizeArray[0].getName() + ": " + sizeArray[0].getfileSize() + ", " + sizeArray[2].getName() + ": " + sizeArray[2].getfileSize();	
				}
				else{
					z = sizeArray[1].getName() + ": " + sizeArray[1].getfileSize() + ", " + sizeArray[2].getName() + ": " + sizeArray[2].getfileSize() + ", " + sizeArray[0].getName() + ": " + sizeArray[0].getfileSize();	
				}
			}
			else if (sizeArray[2].getfileSize() > sizeArray[0].getfileSize() && sizeArray[2].getfileSize() > sizeArray[1].getfileSize()){
				if (sizeArray[0].getfileSize() > sizeArray[1].getfileSize()){
					z = sizeArray[2].getName() + ": " + sizeArray[2].getfileSize() + ", " + sizeArray[0].getName() + ": " + sizeArray[0].getfileSize() + ", " + sizeArray[1].getName() + ": " + sizeArray[1].getfileSize();	
				}
				else{
					z = sizeArray[2].getName() + ": " + sizeArray[2].getfileSize() + ", " + sizeArray[1].getName() + ": " + sizeArray[1].getfileSize() + ", " + sizeArray[0].getName() + ": " + sizeArray[0].getfileSize();	
				}
			}
		}
		else if(sizeArray[1] != null){
			if (sizeArray[0].getfileSize() > sizeArray[1].getfileSize()) {
				z = sizeArray[0].getName() + ": " + sizeArray[0].getfileSize() + ", " + sizeArray[1].getName() + ": " + sizeArray[1].getfileSize();				
			}
			else{
				z = sizeArray[1].getName() + ": " + sizeArray[1].getfileSize() + ", " + sizeArray[0].getName() + ": " + sizeArray[0].getfileSize();
			}
		}
		else{
			z = sizeArray[0].getName() + ": " + sizeArray[0].getfileSize();
		}
		
		return z;
	}
	/**
	 * prints a formatted list of directories under cursor.
	 * @param a
	 * @param numOfTab
	 */
	public void printDirectoryTree(DirectoryNode a, int numOfTab){
		a.printD(a, numOfTab);
		System.out.println("");
	}
	/**
	 * makes a directory under cursor if parameter name is valid.
	 * @param name
	 * @throws IllegalArgumentException
	 * @throws FullDirectoryException
	 * @throws NotADirectoryException
	 */
	public void makeDirectory(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException{
		if(name.contains(" ") || name.contains("/")){
			throw new IllegalArgumentException("Name cannot contain spaces or forward slashes!");
		}
		else{
			DirectoryNode a = new DirectoryNode();
			a.setName(name);
			a.setFile(false);
			cursor.addChild(a);
		}
	}
	/**
	 * makes file under cursor if parameter name is valid.
	 * @param name
	 * @throws IllegalArgumentException
	 * @throws FullDirectoryException
	 * @throws NotADirectoryException
	 */
	public void makeFile(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException{
		if(name.contains(" ") || name.contains("/")){
			throw new IllegalArgumentException("Name cannot contain spaces or forward slashes!");
		}
		else{
			DirectoryNode a = new DirectoryNode();
			Random rand = new Random(); //instance of random class
      		int upperbound = 4096;
      		int int_random = rand.nextInt(upperbound); 
			a.setfileSize(int_random);
			a.setName(name);
			a.setFile(true);
			cursor.addChild(a);
		}
	}
	
	public void remove(String name) throws IllegalArgumentException, NotADirectoryException{
		
		if (cursor.getLeft().getName().equals(name)){	
			if (cursor.getMiddle() == null){
				cursor.setLeft(null);
			}		
			else{
				cursor.getLeft().setEqual(cursor.getMiddle());
				if (cursor.getRight() == null){
					cursor.setMiddle(null);
				}
				else{
					cursor.getMiddle().setEqual(cursor.getRight());
					cursor.setRight(null);
				}
				
			}
			
		}
		else if (cursor.getMiddle().getName().equals(name)){
			if (cursor.getRight() == null){
				cursor.setMiddle(null);
			}
			else{
				cursor.getMiddle().setEqual(cursor.getRight());
			cursor.setRight(null);
			}			
		}
		else if (cursor.getRight().getName().equals(name)){
			cursor.setRight(null);
		}
		else{
			System.out.println("There is no directory or file with that name in this directory!");
		}
	}
	public void moveFilesSync(DirectoryNode from, DirectoryNode to) throws IllegalArgumentException, NotADirectoryException, FullDirectoryException{
		if(from.getName().contains(" ") || to.getName().contains("/") || to.getName().contains(" ") || from.getName().contains("/")){
			throw new IllegalArgumentException("Name cannot contain spaces or forward slashes!");
		}
		else{
			if (from.getLeft() != null){
				from.getLeft().setParent(to);
				to.addChild(from.getLeft());
				from.setLeft(null);
			}
			if (from.getMiddle() != null){
				from.getMiddle().setParent(to);
				to.addChild(from.getMiddle());
				from.setMiddle(null);
			}
			if (from.getRight() != null){
				from.getRight().setParent(to);
				to.addChild(from.getRight());
				from.setRight(null);
			}
			
		}
	}	
}
