package org.example.OOPs;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

// Abstract class for Payment Methods
abstract class PaymentMethod {
    protected String status;

    public abstract void processPayment(double amount) throws Exception;

    public abstract boolean validatePaymentDetails();

    public String getPaymentStatus() {
        return status;
    }
}



// Credit Card Payment Implementation
class CreditCardPayment extends PaymentMethod {
    private final String cardNumber;
    private final String expiryDate;
    private final String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean validatePaymentDetails() {
        // Validate card number (basic check)
        return cardNumber.matches("\\d{16}") && expiryDate.matches("\\d{2}/\\d{2}") && cvv.matches("\\d{3}");
    }

    @Override
    public void processPayment(double amount) throws Exception {
        if (!validatePaymentDetails()) {
            status = "Failed";
            throw new InvalidPaymentDetailsException("Invalid Credit Card Details");
        }

        if (amount > 0) {
            status = "Success";
            System.out.println("Credit Card Payment of $" + amount + " processed successfully.");
        } else {
            throw new InsufficientFundsException("Insufficient funds for Credit Card Payment.");
        }
    }
}

// PayPal Payment Implementation
class PayPalPayment extends PaymentMethod {
    private final String email;
    private final String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean validatePaymentDetails() {
        // Validate email format
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches() && password.length() > 5; // Password validation
    }

    @Override
    public void processPayment(double amount) throws Exception {
        if (!validatePaymentDetails()) {
            status = "Failed";
            throw new InvalidPaymentDetailsException("Invalid PayPal account details.");
        }

        if (amount > 0) {
            status = "Success";
            System.out.println("PayPal Payment of $" + amount + " processed successfully.");
        } else {
            throw new InsufficientFundsException("Insufficient funds for PayPal Payment.");
        }
    }
}


// Bank Transfer Implementation
class BankTransfer extends PaymentMethod {
    private final String accountNumber;
    private final String bankName;

    public BankTransfer(String accountNumber, String bankName) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    @Override
    public boolean validatePaymentDetails() {
        // Validate account number (basic check) and bank name not empty
        return accountNumber.matches("\\d{10}") && !bankName.isEmpty();
    }

    @Override
    public void processPayment(double amount) throws Exception {
        if (!validatePaymentDetails()) {
            status = "Failed";
            throw new InvalidPaymentDetailsException("Invalid Bank Transfer details.");
        }
        // Simulate bank transfer logic
        if (amount > 0) {
            status = "Success";
            System.out.println("Bank Transfer of $" + amount + " processed successfully.");
        } else {
            throw new InsufficientFundsException("Insufficient funds for Bank Transfer.");
        }
    }
}

// Custom Exception for Insufficient Funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Custom Exception for Invalid Payment Details
class InvalidPaymentDetailsException extends Exception {
    public InvalidPaymentDetailsException(String message) {
        super(message);
    }
}

//PaymentProcessor Class


class PaymentProcessor {
    // List to store transaction history
    private final List<String> transactionHistory;

    public PaymentProcessor() {
        transactionHistory = new ArrayList<>();
    }

    // Method to process the payment
    public void process(PaymentMethod paymentMethod, double amount) {
        String transactionLog;
        try {
            paymentMethod.processPayment(amount);
            transactionLog = "Payment Method: " + paymentMethod.getClass().getSimpleName() +
                    ", Amount: $" + amount +
                    ", Status: SUCCESS";
            transactionHistory.add(transactionLog);
        } catch (Exception e) {
            transactionLog = "Payment Method: " + paymentMethod.getClass().getSimpleName() +
                    ", Amount: $" + amount +
                    ", Status: FAILED, Reason: " + e.getMessage();
            transactionHistory.add(transactionLog);
            System.out.println(e.getMessage());
        }
    }

    // Method to get transaction history
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}

//Main Method for Testing

public class PaymentProcessing {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Test Cases:
        try {
            // Valid Credit Card Payment
            PaymentMethod creditCard = new CreditCardPayment("4111111111111111", "12/25", "123");
            paymentProcessor.process(creditCard, 100);

            // Invalid Credit Card Payment
            PaymentMethod invalidCreditCard = new CreditCardPayment("1234567890123456", "01/20", "abc");
            paymentProcessor.process(invalidCreditCard, 50);

            // Valid PayPal Payment
            PaymentMethod payPal = new PayPalPayment("user@example.com", "securePassword123");
            paymentProcessor.process(payPal, 75);

            // Invalid PayPal Payment
            PaymentMethod invalidPaypal = new PayPalPayment("invalidEmailFormat", "pass");
            paymentProcessor.process(invalidPaypal, 50);

            // Valid Bank Transfer
            PaymentMethod bankTransfer = new BankTransfer("1234567890", "Bank of Java");
            paymentProcessor.process(bankTransfer, 200);

            // Invalid Bank Transfer
            PaymentMethod invalidBankTransfer = new BankTransfer("abc1234567", "");
            paymentProcessor.process(invalidBankTransfer, 300);

            // Print Transaction History
            System.out.println("\nTransaction History:");
            for (String transaction : paymentProcessor.getTransactionHistory()) {
                System.out.println(transaction);
            }

        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }
}