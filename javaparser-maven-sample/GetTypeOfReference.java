 public class GetTypeOfReference { 
 	private static final String FILE_PATH = "RefCheck.java"; 
 	public static void main(String[] args) throws FileNotFoundException { 
 		TypeSolver typeSolver = new CombinedTypeSolver(); 
 		JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver); 
 		JavaParser.getStaticConfiguration().setSymbolResolver(symbolSolver); 
 		CompilationUnit cu = JavaParser.parse(new File(FILE_PATH)); 
 		cu.findAll(AssignExpr.class).forEach(ae -> { 
 			ResolvedType resolvedType = ae.calculateResolvedType(); 
 			System.out.println(ae.toString() + " is a: " + resolvedType); 
 		}); 
 	} 
 }
