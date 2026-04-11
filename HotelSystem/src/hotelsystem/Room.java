package hotelsystem;

import java.util.Scanner;

// Abstract class: shared fields + Input() for all room types.
// implements IBookable → must provide PrintInfo, CalcCost, IsAvailable.
public abstract class Room implements IBookable{

    protected String  roomNumber;
    protected double  pricePerNight;
    protected boolean isAvailable;

    // Each subclass returns its own label.
    public abstract String GetRoomType();

    // Read shared fields. Subclasses call super.Input(sc) then add own fields.
    public void Input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Input Room Number: ");
            try{
                roomNumber = sc.nextLine().trim();
                if(roomNumber.isEmpty()){
                    throw new Exception("Room number must not be empty!");
                }break;
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        while(true){
            System.out.print("Input Price per Night: ");
            try{
                pricePerNight = Float.parseFloat(sc.nextLine().trim());
                if (pricePerNight <= 0 ) 
                    throw new Exception("Price must be > 0.");
                 break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());                         
            }
        }
        isAvailable =true;
    }

    @Override
    public void PrintInfo() {
        System.out.println("Room: " + roomNumber + ", Price/Night" + pricePerNight + ", Available: " +(isAvailable ? "Yes" : "No") + ", Type" + GetRoomType() );
    }

    /**
     *
     * @param nights
     * @return
     */
    @Override
    public double CalcCost(int nights) {
        return pricePerNight * nights;
    }

    @Override
    public boolean IsAvailable() {
        return isAvailable;
    }
}
            