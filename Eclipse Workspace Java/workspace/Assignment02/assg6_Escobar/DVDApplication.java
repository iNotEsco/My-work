//Jason Aaron Escobar Escoto

package assg6_Escobar;
import java.util.*;
public class DVDApplication {

	public static void main(String[] args){

		ArrayListDVDCollection dvds = new ArrayListDVDCollection();
		dvds.loadData("DVDCollection.txt");
		Scanner kbd = new Scanner(System.in);
		int input;
		do{
			System.out.println("Menu:\n(Choose either 1 through 7)\n(1)Add new DVD Entry\n" +
					"(2)Change existing DVD entry\n(3)Look Up DVD Entry\n" +
					"(4)Display DVDs By Category\n(5)Remove DVD Entry\n" +
					"(6)Save Data\n(0)Exit\n");
			input = kbd.nextInt();
			kbd.nextLine();
			switch(input){
			case 1:{

				System.out.print("Enter DVD data:\nTitle: ");
				String temp1, temp2, temp3, temp4, temp5;
				temp1 = kbd.nextLine();
				if(dvds.lookupEntry(temp1) == null){
					System.out.print("Category: ");
					temp2 = kbd.nextLine();
					System.out.print("Running Time (followed by\" minutes\"): ");
					temp3 = kbd.nextLine();
					System.out.print("Year: ");
					temp4 = kbd.nextLine();
					System.out.print("Price: ");
					temp5 = kbd.nextLine();
					dvds.addOrChangeDVD(temp1, temp2, temp3, temp4, temp5);
				} else{
					System.out.println(temp1 + " is already in the collection.");
				}
				break;
			}
			case 2:{
				System.out.print("Enter DVD title to modify: ");
				String tempOpt = kbd.nextLine();
				DVD tempdvd = dvds.lookupEntry(tempOpt);
				if(tempdvd != null){
					System.out.println("Information of " + tempOpt);
					System.out.println("(1)Title: " + tempdvd.getTitle());
					System.out.println("(2)Category: " + tempdvd.getCategory());
					System.out.println("(3)Running Time: " + tempdvd.getTime());
					System.out.println("(4)Year: " + tempdvd.getYear());
					System.out.println("(5)Price: " + tempdvd.getPrice());
					System.out.println("(0)Return to Main Menu");
					System.out.println("(Enter a option 1 through 7 to modify. Title can not be changed.)");
					int input2 = kbd.nextInt();
					kbd.nextLine();
					switch(input2){
					case 1:
						System.out.print("The title can not be changed.");
						break;
					case 2:
						System.out.print("Enter the new category: ");
						dvds.addOrChangeDVD(tempdvd.getTitle(), kbd.nextLine(), tempdvd.getTime(), tempdvd.getYear(), tempdvd.getPrice());
						break;
					case 3:
						System.out.print("Enter the new running time (followed by\" minutes\"): ");
						dvds.addOrChangeDVD(tempdvd.getTitle(), tempdvd.getCategory(), kbd.nextLine(), tempdvd.getYear(), tempdvd.getPrice());
						break;
					case 4:
						System.out.print("Enter the new year: ");
						dvds.addOrChangeDVD(tempdvd.getTitle(), tempdvd.getCategory(), tempdvd.getTime(), kbd.nextLine(), tempdvd.getPrice());
						break;
					case 5:
						System.out.print("Enter the new price: ");
						dvds.addOrChangeDVD(tempdvd.getTitle(), tempdvd.getCategory(), tempdvd.getTime(), tempdvd.getYear(), kbd.nextLine());
						break;
					case 0: 
						break;
					}
				}else{
					System.out.println(tempOpt + " does not exist.");
				}

				break;
			}
			case 3:{
				System.out.println("Enter title to look up:");
				String tempInfo = kbd.nextLine();
				DVD tempdvd = dvds.lookupEntry(tempInfo);
				if(tempdvd != null){
					System.out.println(tempdvd + "\n");
				} else{
					System.out.println(tempInfo + " was not found in the collection.\n");
				}
				break;

			}
			case 4:{
				System.out.println("Enter the category to look up:");
				String tempCat = kbd.nextLine();
				ArrayList<DVD> dvdsInCategory = dvds.getDVDsInCategory(tempCat);
				if(dvdsInCategory != null){
					Iterator<DVD> iter = dvdsInCategory.iterator();
					while (iter.hasNext()){
						System.out.println(iter.next());

					}
				}else{
					System.out.println("There are no DVDs in this category.");
				}
				break;

			}
			case 5:
				System.out.println("Enter tile of DVD to remove");
				String tempInfo = kbd.nextLine();
				if(dvds.lookupEntry(tempInfo) != null){
					System.out.print("The following movie has been removed\n" + dvds.removeDVD(tempInfo));
				} else{
					System.out.println(tempInfo + " is not in the collection.");
				}				break;
			case 6:
				dvds.save();
				break;
			case 0:
				dvds.save();
				System.out.println("Exiting program");
				break;
			}
		}while(input != 0);
		kbd.close();
	}
}
