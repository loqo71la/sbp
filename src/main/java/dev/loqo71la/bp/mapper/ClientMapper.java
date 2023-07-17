package dev.loqo71la.bp.mapper;

import dev.loqo71la.bp.dto.ClientDto;
import dev.loqo71la.bp.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements Mapper<ClientDto, Client> {

    /**
     * Converts client to clientDto.
     *
     * @param client to be converted.
     * @return a clientDto.
     */
    public ClientDto toDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getFullName(),
                client.getAddress(),
                client.getPhone(),
                client.getPassword(),
                client.isStatus()
        );
    }

    /**
     * Converts clientDto to client.
     *
     * @param clientDto to be converted.
     * @return a client.
     */
    public Client toModel(ClientDto clientDto) {
        Client client = new Client();
        client.setFullName(clientDto.fullName());
        client.setAddress(clientDto.address());
        client.setPhone(clientDto.phone());
        client.setPassword(clientDto.password());
        client.setStatus(clientDto.status());
        return client;
    }
}
