package BuilderPatternExample;

// Driver class
public class Test {
    public static void main(String args[])
    {
        
       Computer com1= new Computer.Builder().build();
       System.out.println(com1);
       Computer com2= new Computer.Builder().setCpu("Intel").setRam(8).setStorage(512).build();
       System.out.println(com2);
       Computer com3= new Computer.Builder().setCpu("Intel").setRam(8).build();
       System.out.print(com3);
    }
}


class Computer {

    // instance fields
    private String cpu;
    private int ram;
    private int storage;

    private Computer(Builder builder)
    {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    // Static class Builder
    public static class Builder {

        // instance fields
        private String cpu;
        private int ram;
        private int storage;

        public Builder setCpu(String cpu)
        {
            this.cpu = cpu;
            return this;
        }
        public Builder setRam(int ram)
        {
            this.ram = ram;
            return this;
        }
        public Builder setStorage(int storage)
        {
            this.storage = storage;
            return this;
        }

        // build method to deal with outer class
        // to return outer instance
        public Computer build()
        {
            return new Computer(this);
        }
    }

    @Override
    public String toString()
    {
        return "Computer [CPU = " + this.cpu + ", RAM = " + this.ram + 
                            ", Storage = " + this.storage+"]";
    }
}
