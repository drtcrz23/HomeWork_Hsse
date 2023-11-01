package BankSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
  public ArrayList<Client> clients;
  private HashMap<String, Integer> accounts = new HashMap<>();

  public Bank addClient(String name, String surname, String phone) {
    clients.add(new Client(name, surname, phone));
    return this;
  }

  public Bank deleteClient(Client client) {
    clients.remove(client);
    return this;
  }

  public Client getClient(String numberPhone) {
    for (Client client : clients) {
      if (client.getPhone().equals(numberPhone)) {
        return client;
      }
    }
    return null;
  }

  public ArrayList<Client> getAllClients() {
    return this.clients;
  }

  public int sumOfAccountsOfOneUser() {
    int sum = 0;
    for (Map.Entry<String, Integer> item : accounts.entrySet()) {
      sum += item.getValue();
    }
    return sum;
  }
}
