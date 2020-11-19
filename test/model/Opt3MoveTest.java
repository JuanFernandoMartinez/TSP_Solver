package model;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Opt3Move.OptCase;

public class Opt3MoveTest{
	
	Opt3Move o3m=new Opt3Move();
	OptCase [] optCases = OptCase.values();
	Node[] nodes= {new Node(1,2,2),new Node(2,0,3),new Node(3,4,0),new Node(4,3,-2),new Node(5,0,-3),new Node(6,-3,-2),
			new Node(7,-2,0),new Node(8,-3,2),new Node(9,-4,0),new Node(10,3,3)};
	
	@Test
	public void testMake3OptMove() {
	
		int i=0;
		int j=3;
		int k=7;
		
		Node [] tourCase0= {nodes[2],nodes[0],nodes[9],nodes[1],nodes[7],nodes[6],nodes[8],nodes[5],nodes[4],nodes[3]};
		Node [] tourCase1= {nodes[4],nodes[0],nodes[9],nodes[1],nodes[7],nodes[6],nodes[8],nodes[5],nodes[2],nodes[3]};
		Node [] tourCase2= {nodes[2],nodes[0],nodes[9],nodes[1],nodes[5],nodes[8],nodes[6],nodes[7],nodes[4],nodes[3]};
		Node [] tourCase3= {nodes[2],nodes[1],nodes[9],nodes[0],nodes[7],nodes[6],nodes[8],nodes[5],nodes[4],nodes[3]};
		Node [] tourCase4= {nodes[2],nodes[1],nodes[9],nodes[0],nodes[5],nodes[8],nodes[6],nodes[7],nodes[4],nodes[3]};
		Node [] tourCase5= {nodes[4],nodes[1],nodes[9],nodes[0],nodes[7],nodes[6],nodes[8],nodes[5],nodes[2],nodes[3]};
		Node [] tourCase6= {nodes[4],nodes[0],nodes[9],nodes[1],nodes[5],nodes[8],nodes[6],nodes[7],nodes[2],nodes[3]};
		Node [] tourCase7= {nodes[4],nodes[1],nodes[9],nodes[0],nodes[5],nodes[8],nodes[6],nodes[7],nodes[2],nodes[3]};
		Node[][] resultado= {tourCase0,tourCase1,tourCase2,tourCase3,tourCase4,tourCase5,tourCase6,tourCase7};
		
		for (int optCase = 0; optCase < optCases.length ; optCase++) {
			Node [] tour= {nodes[2],nodes[0],nodes[9],nodes[1],nodes[7],nodes[6],nodes[8],nodes[5],nodes[4],nodes[3]};
			assertArrayEquals(resultado[optCase], o3m.make3OptMove(tour, i, j, k, optCases[optCase]));
		}
		
	}

	@Test
	public void testGainExpected() {

		Model model=new Model(nodes);
		
		int X1=2;
		int X2=3;
		int Y1=5;
		int Y2=6;
		int Z1=8;
		int Z2=9;
		
		double resultado[]= {0,3.14815891663630,-1.78482121101861,8.19313874141544,8.30326261254285,
				9.10750542217767,1.14815891663630,9.00245050432368};
		
		for (int optCase = 0; optCase < optCases.length ; optCase++) {
			
			assertEquals(resultado[optCase], o3m.gainExpected(X1,X2,Y1,Y2,Z1,Z2,optCases[optCase],model),0.00000001);
		
		}

	}

}
