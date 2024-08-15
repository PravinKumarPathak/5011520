package DependencyInjectionExample;

public class Main {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        String customerName = customerService.getCustomerName(1);
        System.out.println(customerName);
    }
}



interface CustomerRepository {
    String findCustomerById(int id);
}


class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulating a database lookup
        return "Customer Name for ID " + id;
    }
}


class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerName(int id) {
        return customerRepository.findCustomerById(id);
    }
}

