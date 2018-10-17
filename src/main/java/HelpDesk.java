import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

import static java.util.Comparator.*;

public class HelpDesk {

    private final Comparator<Enquiry> BY_CATEGORY = comparing(Enquiry::getCategory);

    private final Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

    public void enquire(Customer customer, final Category category){

        enquiries.offer(new Enquiry(customer, category));
    }

    public void processPrinterEnquiry(){

        processEnquiry(
                enq -> enq.getCategory() == Category.PRINTER,
                "Is it out of paper?");

    }

    public void processGeneralEnquiry(){

        processEnquiry(
                enq -> enq.getCategory() != Category.PRINTER,
                "Have you tried turning it on and off again?");

    }

    public void processAllEnquires(){

        Enquiry enquiry;

        while((enquiry = enquiries.peek()) != null){

            if (enquiry.getCategory() == Category.PRINTER){
                processPrinterEnquiry();
            } else{
                processGeneralEnquiry();
            }
        }
    }

    private void processEnquiry(Predicate<Enquiry> predicate, String message) {

        final Enquiry enquiry = enquiries.peek();

        if (enquiry != null && predicate.test(enquiry)) {
            enquiries.remove();
            enquiry.getCustomer().reply(message);
        } else {
            System.out.println("No work to do, let's have some coffee!");
        }
    }

    public static void main(String[] args) {

        HelpDesk helpDesk = new HelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);
        helpDesk.enquire(Customer.MARY, Category.COMPUTER);

        helpDesk.processAllEnquires();

    }

}
