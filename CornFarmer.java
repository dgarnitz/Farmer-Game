public class CornFarmer extends Farmer {
    public String type = "Corn";

    /**
     * Class constructor method
     * @param grid
     * @param yCoordinate
     * @param xCoordinate
     */
    public CornFarmer(AbstractGrid grid, int yCoordinate, int xCoordinate) {
        this.grid = grid;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        grid.registerItem(xCoordinate, yCoordinate, this);
    }

    /**
     * This method processes the nutrition production activity of the Corn Farmer. It works by checking if the
     * conditions for production are met, and calling recordProduction and addToStock on 25 units of nutritions if they
     * are. This condition check consists of checking that the timeStep's value is a multple of 4 and the
     * checkOtherFarmers() method has returned false, meaning there are not any farmers located adjacent to this
     * instace. If those conditions are not met, this method does nothing.
     * @param timeStep
     */
    @Override
    public void process(TimeStep timeStep) {
        int step = timeStep.getValue();
        boolean check = checkOtherFarmers();
        if((step) % 4 == 0 && !check) {
            grid.recordProduction(25);
            addToStock(25);
        }
    }

    /**
     * Overrides toString method to return the class' type attribute and along with the stock at the farmer's cell
     * @return
     */
    @Override
    public String toString(){
        int stock = getStock();
        return type + "(" + stock + ")";
    }
}