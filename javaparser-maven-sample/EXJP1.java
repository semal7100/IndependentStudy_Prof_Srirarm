 private static final String FILE_PATH = "ReversePolishNotation.java"; 
 public static void main(String[] args) throws Exception 
{ 
	CompilationUnit cu = JavaParser.parse(new File(FILE_PATH)); 
}

private static class MethodNamePrinter extends VoidVisitorAdapter<Void> {  
	@Override 
	public void visit(MethodDeclaration md, Void arg) 
	{ 
		super.visit(md, arg); 
		System.out.println("Method Name Printed: " + md.getName()); 
	} 
}

VoidVisitor<?> methodNameVisitor = new MethodNamePrinter(); 
methodNameVisitor.visit(cu, null);
