package G2;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class) 
public class ShapeClassifierTest {

	private ShapeClassifier shaperClassifier=null;
	private static ArrayList<Object[]> ans=null;
	
	private static void readData(String inputPath) throws IOException {
		InputStreamReader fr = new InputStreamReader(new FileInputStream(inputPath));
		BufferedReader br = new BufferedReader(fr);
		String rec;
//		rec = br.readLine();
//		String[] temp=rec.split(",");
//		for (int i=0;i<temp.length;i++){
//			names.put(i,temp[i]);
//		}
		
		ans=new ArrayList<Object[]>();
		try {
			while ((rec = br.readLine()) != null) {
				String[] temp=new String[2];
				for(int i=rec.length()-1;i>=0;i--){
					if (rec.charAt(i)==','){
						temp[1]=rec.substring(i+1,rec.length());
						temp[0]=rec.substring(1,i-1);
						break;
					}
				}
				ans.add(temp);
			}
			 
		}catch(Exception e){
			
		}
	}
	
	
	@Parameters
    public static Iterable<Object[]> prepareData() throws IOException
    {
    	String path="F:\\17654- software artifact\\G2\\white.csv";
    	readData(path);
        return ans;
    }
    
    private String input;  
    private String expected;  
  
    public ShapeClassifierTest(String input, String expected) {  
        this.input = input;  
        this.expected = expected;  
    }
	
	
	@Test
	public void testEvaluateGuess() {
		//String expectedResult="123";
		
		
		String real=shaperClassifier.evaluateGuess(input);
		System.out.println(expected+" "+real);
		assertEquals(expected,real);
		
	}
	
	
	@BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("in BeforeClass================");
        System.out.println("load Testcases================");
    }  
  
    @AfterClass  
    public static void tearDownAfterClass() throws Exception {  
        System.out.println("in AfterClass=================");  
    }  
  
    @Before  
    public void before() {  
    	shaperClassifier=new ShapeClassifier();
    }  
  
    @After  
    public void after() {  
    }  
  
    
	

}
