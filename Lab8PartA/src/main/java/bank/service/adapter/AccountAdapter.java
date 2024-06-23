package bank.service.adapter;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountServiceImpl;
import bank.service.dto.AccountDTO;
import bank.service.dto.AccountEntryDTO;
import bank.service.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountAdapter {

    //Get Account from AccountDTO
    public static Account getAccountFromAccountDTO(AccountDTO accountDTO){
        return new Account(accountDTO.getAccountNumber());
    }

    public static AccountDTO getAccountDTOFromAccount(Account account) {
        CustomerDTO customerDTO = new CustomerDTO(account.getCustomer().getName());
        Collection<AccountEntryDTO> accountEntryDTOs = getAccountEntryDTOsFromAccountEntries(account.getEntryList());
        return new AccountDTO(account.getAccountNumber(), customerDTO, accountEntryDTOs,account.getBalance());
    }

    private static Collection<AccountEntryDTO> getAccountEntryDTOsFromAccountEntries(Collection<AccountEntry> entries) {
        Collection<AccountEntryDTO> entryDTOs = new ArrayList<>();
        for (AccountEntry entry : entries) {
            entryDTOs.add(new AccountEntryDTO(entry.getDate(), entry.getAmount(), entry.getDescription(), entry.getFromAccountNumber(), entry.getFromPersonName()));
        }
        return entryDTOs;
    }


}
