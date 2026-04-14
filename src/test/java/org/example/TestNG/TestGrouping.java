package org.example.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestGrouping {

    // ============================================================
    // Test Case 1: Smoke + Regression + Functional
    // ============================================================
    @Test(groups = {"Smoke", "Regression", "Functional"},
            description = "TC01 - Verify User Login with Valid Credentials")
    public void testUserLogin() {
        System.out.println("==============================================");
        System.out.println("TC01 - [Smoke | Regression | Functional]");
        System.out.println("Test: Verify User Login with Valid Credentials");
        System.out.println("==============================================");

        String username = "admin";
        String password = "admin123";

        // Simulating login validation
        boolean isLoggedIn = username.equals("admin") && password.equals("admin123");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Login Status: " + (isLoggedIn ? "SUCCESS" : "FAILED"));

        Assert.assertTrue(isLoggedIn, "User should be able to login with valid credentials");
        System.out.println("TC01 - PASSED\n");
    }

    // ============================================================
    // Test Case 2: Smoke + Regression
    // ============================================================
    @Test(groups = {"Smoke", "Regression"},
            description = "TC02 - Verify Application Homepage Loads Successfully")
    public void testHomepageLoad() {
        System.out.println("==============================================");
        System.out.println("TC02 - [Smoke | Regression]");
        System.out.println("Test: Verify Application Homepage Loads Successfully");
        System.out.println("==============================================");

        String expectedTitle = "Welcome to MyApp";
        String actualTitle   = "Welcome to MyApp"; // Simulated page title

        System.out.println("Expected Title: " + expectedTitle);
        System.out.println("Actual Title  : " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle,
                "Homepage title should match expected title");
        System.out.println("TC02 - PASSED\n");
    }

    // ============================================================
    // Test Case 3: Smoke + Functional
    // ============================================================
    @Test(groups = {"Smoke", "Functional"},
            description = "TC03 - Verify Search Functionality Returns Results")
    public void testSearchFunctionality() {
        System.out.println("==============================================");
        System.out.println("TC03 - [Smoke | Functional]");
        System.out.println("Test: Verify Search Functionality Returns Results");
        System.out.println("==============================================");

        String searchKeyword    = "TestNG";
        int    simulatedResults = 25; // Simulated search result count

        System.out.println("Search Keyword : " + searchKeyword);
        System.out.println("Results Found  : " + simulatedResults);

        Assert.assertTrue(simulatedResults > 0,
                "Search should return at least one result for keyword: " + searchKeyword);
        System.out.println("TC03 - PASSED\n");
    }

    // ============================================================
    // Test Case 4: Regression + Functional
    // ============================================================
    @Test(groups = {"Regression", "Functional"},
            description = "TC04 - Verify User Registration with Valid Data")
    public void testUserRegistration() {
        System.out.println("==============================================");
        System.out.println("TC04 - [Regression | Functional]");
        System.out.println("Test: Verify User Registration with Valid Data");
        System.out.println("==============================================");

        String firstName = "John";
        String lastName  = "Doe";
        String email     = "john.doe@example.com";
        String phone     = "9876543210";

        // Simulating registration validation
        boolean isValidEmail = email.contains("@") && email.contains(".");
        boolean isValidPhone = phone.length() == 10;
        boolean isRegistered = !firstName.isEmpty() && !lastName.isEmpty()
                && isValidEmail && isValidPhone;

        System.out.println("First Name   : " + firstName);
        System.out.println("Last Name    : " + lastName);
        System.out.println("Email        : " + email);
        System.out.println("Phone        : " + phone);
        System.out.println("Valid Email  : " + isValidEmail);
        System.out.println("Valid Phone  : " + isValidPhone);
        System.out.println("Registration : " + (isRegistered ? "SUCCESS" : "FAILED"));

        Assert.assertTrue(isRegistered, "User registration should succeed with valid data");
        System.out.println("TC04 - PASSED\n");
    }

    // ============================================================
    // Test Case 5: Smoke Only
    // ============================================================
    @Test(groups = {"Smoke"},
            description = "TC05 - Verify Database Connection is Active")
    public void testDatabaseConnection() {
        System.out.println("==============================================");
        System.out.println("TC05 - [Smoke]");
        System.out.println("Test: Verify Database Connection is Active");
        System.out.println("==============================================");

        String dbHost   = "localhost";
        int    dbPort   = 3306;
        String dbName   = "myapp_db";

        // Simulating DB connection check
        boolean isConnected = dbHost.equals("localhost") && dbPort == 3306;

        System.out.println("DB Host      : " + dbHost);
        System.out.println("DB Port      : " + dbPort);
        System.out.println("DB Name      : " + dbName);
        System.out.println("DB Connected : " + isConnected);

        Assert.assertTrue(isConnected,
                "Database connection should be active on " + dbHost + ":" + dbPort);
        System.out.println("TC05 - PASSED\n");
    }

    // ============================================================
    // Test Case 6: Regression Only
    // ============================================================
    @Test(groups = {"Regression"},
            description = "TC06 - Verify Password Reset Functionality")
    public void testPasswordReset() {
        System.out.println("==============================================");
        System.out.println("TC06 - [Regression]");
        System.out.println("Test: Verify Password Reset Functionality");
        System.out.println("==============================================");

        String registeredEmail = "user@example.com";
        String newPassword     = "NewPass@123";
        String confirmPassword = "NewPass@123";

        // Simulating password reset validation
        boolean isEmailValid      = registeredEmail.contains("@");
        boolean isPasswordMatch   = newPassword.equals(confirmPassword);
        boolean isPasswordStrong  = newPassword.length() >= 8;
        boolean isResetSuccessful = isEmailValid && isPasswordMatch && isPasswordStrong;

        System.out.println("Registered Email  : " + registeredEmail);
        System.out.println("New Password      : " + newPassword);
        System.out.println("Confirm Password  : " + confirmPassword);
        System.out.println("Email Valid       : " + isEmailValid);
        System.out.println("Password Match    : " + isPasswordMatch);
        System.out.println("Password Strong   : " + isPasswordStrong);
        System.out.println("Reset Status      : " + (isResetSuccessful ? "SUCCESS" : "FAILED"));

        Assert.assertTrue(isResetSuccessful,
                "Password reset should succeed with valid email and matching passwords");
        System.out.println("TC06 - PASSED\n");
    }

    // ============================================================
    // Test Case 7: Functional Only
    // ============================================================
    @Test(groups = {"Functional"},
            description = "TC07 - Verify Shopping Cart Add and Remove Items")
    public void testShoppingCart() {
        System.out.println("==============================================");
        System.out.println("TC07 - [Functional]");
        System.out.println("Test: Verify Shopping Cart Add and Remove Items");
        System.out.println("==============================================");

        // Simulating shopping cart operations
        java.util.List<String> cart = new java.util.ArrayList<>();

        // Add items
        cart.add("Laptop");
        cart.add("Mouse");
        cart.add("Keyboard");
        System.out.println("Items Added to Cart : " + cart);
        Assert.assertEquals(cart.size(), 3, "Cart should have 3 items after adding");

        // Remove one item
        cart.remove("Mouse");
        System.out.println("After Removing Mouse: " + cart);
        Assert.assertEquals(cart.size(), 2, "Cart should have 2 items after removal");

        // Verify specific item removed
        Assert.assertFalse(cart.contains("Mouse"),
                "Mouse should not be present in cart after removal");

        // Verify remaining items
        Assert.assertTrue(cart.contains("Laptop"),   "Laptop should still be in cart");
        Assert.assertTrue(cart.contains("Keyboard"), "Keyboard should still be in cart");

        System.out.println("Final Cart Items    : " + cart);
        System.out.println("TC07 - PASSED\n");
    }
}