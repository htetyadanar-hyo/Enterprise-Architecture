package bank.service.adapter;

import bank.domain.AccountEntry;
import bank.service.dto.AccountEntryDTO;

public class AccountEntryAdapter {
    public static AccountEntryDTO getAccountEntryDTOFromAccountEntry(AccountEntry entry) {
        return new AccountEntryDTO(entry.getDate(), entry.getAmount(), entry.getDescription(),
                entry.getFromAccountNumber(), entry.getFromPersonName());
    }

    public static  AccountEntry getAccountEntryFromAccountEntryDTO(AccountEntryDTO accountEntryDTO){
        return new AccountEntry(accountEntryDTO.getDate(),accountEntryDTO.getAmount(),accountEntryDTO.getDescription(),
                accountEntryDTO.getFromAccountNumber(),accountEntryDTO.getFromPersonName());
    }
}
