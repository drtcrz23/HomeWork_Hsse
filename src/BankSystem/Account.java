package BankSystem;

public class Account {

  private Currency currency;
  private int amount;
  private String label;

  public Account(Currency currency, String label, int amount) {
    this.currency = currency;
    this.label = label;
    this.amount = amount;
  }
}
