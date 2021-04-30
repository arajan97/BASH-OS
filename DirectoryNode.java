
public class DirectoryNode {
	private DirectoryNode left;
	private DirectoryNode middle;
	private DirectoryNode right;
	private DirectoryNode parent;
	private String name;
	private boolean isFile;
	private int fileSize;
	
	/**
	 * helper method for DirectoryTree : printDirectory
	 * @param a
	 * @param numOfTab
	 */
	public void printD(DirectoryNode a, int numOfTab){
		System.out.println();
		for(int i = numOfTab; i >= 0; i--){
			System.out.print("\t");
		}
		if(a.isFile()){
			System.out.print("- " + a.getName());
		}
		else{
			System.out.print("|- " + a.getName());
		}
		if(a.getLeft() != null){
			a.getLeft().printD(a.getLeft(), (numOfTab+1));
		}
		if(a.getMiddle() != null){
			a.getMiddle().printD(a.getMiddle(), (numOfTab+1));
		}
		if(a.getRight() != null){
			a.getRight().printD(a.getRight(), (numOfTab+1));
		}
		
	}

	public void setEqual(DirectoryNode newValues){
		this.setName(newValues.getName());
		this.setFile(newValues.isFile);
		this.setLeft(newValues.getLeft());
		this.setMiddle(newValues.getMiddle());
		this.setRight(newValues.getRight());
		this.setParent(newValues.getParent());
		this.setfileSize(newValues.getfileSize());
	}
	/**
	 * 
	 * @param newChild
	 * @throws FullDirectoryException
	 * @throws NotADirectoryException
	 * adds child to directory-node in this order: left, middle, right
	 */
	public void addChild(DirectoryNode newChild) throws FullDirectoryException, NotADirectoryException{
		if(!(this.isFile())){
			if(this.getLeft() == null){
				this.setLeft(newChild);
				this.getLeft().setParent(this);
				
			}
			else if(this.getMiddle() == null){
				this.setMiddle(newChild);
				this.getMiddle().setParent(this);
			}
			else if(this.getRight() == null){
				this.setRight(newChild);
				this.getRight().setParent(this);
			}
			else{
				throw new FullDirectoryException();				
			}
		}
		else{
			throw new NotADirectoryException(); 
		}
	}
	/**
	 * @return the parent
	 */
	public DirectoryNode getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(DirectoryNode parent) {
		this.parent = parent;
	}
	public void setfileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public int getfileSize() {
		return fileSize;
	}
	/**
	 * @return the left
	 */
	public DirectoryNode getLeft() {
		return left;
	}
	/**
	 * @return the middle
	 */
	public DirectoryNode getMiddle() {
		return middle;
	}
	/**
	 * @return the right
	 */
	public DirectoryNode getRight() {
		return right;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the isFile
	 */
	public boolean isFile() {
		return isFile;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(DirectoryNode left) {
		this.left = left;
	}
	/**
	 * @param middle the middle to set
	 */
	public void setMiddle(DirectoryNode middle) {
		this.middle = middle;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(DirectoryNode right) {
		this.right = right;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param isFile the isFile to set
	 */
	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
}
