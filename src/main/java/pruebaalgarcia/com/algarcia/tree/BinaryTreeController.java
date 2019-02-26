package pruebaalgarcia.com.algarcia.tree;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinaryTreeController {
	
	private BinaryTree tree = null;
	
	public BinaryTreeController() {
		System.out.println("Se crea el objeto controller");
		tree = new BinaryTree();
	}
	
	@RequestMapping("/create")
	public String createBinaryTree(@RequestParam(value="values") String values) {
		System.out.println("Ingreso a servicio");
        tree.createBinaryTree(values);
		return "The binary tree was created";
	
	}
	
	@RequestMapping("/print")
	public String printBinaryTree() {
		System.out.println("Ingreso a servicio de impresion");
        tree.traverseInOrder(tree.root);
		return "The binary tree was created";
	
	}
	
	@RequestMapping("/getCommon")
	public String getCommonBinaryTree(@RequestParam(value="nodo1") String nodo1, 
									  @RequestParam(value="nodo2") String nodo2) {
		System.out.println("Ingreso a servicio de impresion");
        Integer commonNode = tree.findLCA(Integer.parseInt(nodo1), Integer.parseInt(nodo2));
		return "The common node is " + commonNode;
	
	}

	
	

}
