package com.pragma.credits.infrastructure.adapters.jpa;

import com.pragma.credits.infrastructure.adapters.jpa.entities.ClientJpaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientJpaAdapterTest {

    @Mock
    private ClientJpaRepository clientJpaRepository;

    private ClientJpaAdapter clientJpaAdapter;

    @BeforeEach
    void setUp() {
        clientJpaAdapter = new ClientJpaAdapter(clientJpaRepository);
        ReflectionTestUtils.setField(clientJpaAdapter, "modelMapper", new org.modelmapper.ModelMapper());
    }

    @Test
    void save_shouldPersistClientEntity() {
        ClientJpaEntity entity = createTestEntity();
        when(clientJpaRepository.save(any(ClientJpaEntity.class))).thenReturn(entity);

        ClientJpaEntity result = clientJpaAdapter.save(entity);

        assertNotNull(result);
        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getDocumentNumber(), result.getDocumentNumber());
        verify(clientJpaRepository).save(any(ClientJpaEntity.class));
    }

    @Test
    void findById_shouldReturnClient_whenExists() {
        UUID clientId = UUID.randomUUID();
        ClientJpaEntity entity = createTestEntity();
        entity.setId(clientId);
        when(clientJpaRepository.findById(clientId)).thenReturn(java.util.Optional.of(entity));

        java.util.Optional<ClientJpaEntity> result = clientJpaAdapter.findById(clientId);

        assertTrue(result.isPresent());
        assertEquals(clientId, result.get().getId());
    }

    @Test
    void findById_shouldReturnEmpty_whenNotExists() {
        UUID nonExistentId = UUID.randomUUID();
        when(clientJpaRepository.findById(nonExistentId)).thenReturn(java.util.Optional.empty());

        java.util.Optional<ClientJpaEntity> result = clientJpaAdapter.findById(nonExistentId);

        assertFalse(result.isPresent());
    }

    @Test
    void findByDocumentNumber_shouldReturnClient_whenDocumentExists() {
        String documentNumber = "12345678";
        ClientJpaEntity entity = createTestEntity();
        entity.setDocumentNumber(documentNumber);
        when(clientJpaRepository.findByDocumentNumber(documentNumber))
            .thenReturn(java.util.Optional.of(entity));

        java.util.Optional<ClientJpaEntity> result = 
            clientJpaAdapter.findByDocumentNumber(documentNumber);

        assertTrue(result.isPresent());
        assertEquals(documentNumber, result.get().getDocumentNumber());
    }

    @Test
    void findByEmail_shouldReturnClient_whenEmailExists() {
        String email = "test@example.com";
        ClientJpaEntity entity = createTestEntity();
        entity.setEmail(email);
        when(clientJpaRepository.findByEmail(email))
            .thenReturn(java.util.Optional.of(entity));

        java.util.Optional<ClientJpaEntity> result = clientJpaAdapter.findByEmail(email);

        assertTrue(result.isPresent());
        assertEquals(email, result.get().getEmail());
    }

    @Test
    void existsByDocumentNumber_shouldReturnTrue_whenDocumentExists() {
        String documentNumber = "12345678";
        when(clientJpaRepository.existsByDocumentNumber(documentNumber)).thenReturn(true);

        boolean result = clientJpaAdapter.existsByDocumentNumber(documentNumber);

        assertTrue(result);
    }

    @Test
    void existsByDocumentNumber_shouldReturnFalse_whenDocumentNotExists() {
        String nonExistentDocument = "00000000";
        when(clientJpaRepository.existsByDocumentNumber(nonExistentDocument)).thenReturn(false);

        boolean result = clientJpaAdapter.existsByDocumentNumber(nonExistentDocument);

        assertFalse(result);
    }

    @Test
    void deleteById_shouldCallRepository() {
        UUID clientId = UUID.randomUUID();
        doNothing().when(clientJpaRepository).deleteById(clientId);

        clientJpaAdapter.deleteById(clientId);

        verify(clientJpaRepository).deleteById(clientId);
    }

    @Test
    void findAll_shouldReturnAllClients() {
        ClientJpaEntity entity1 = createTestEntity();
        entity1.setId(UUID.randomUUID());
        ClientJpaEntity entity2 = createTestEntity();
        entity2.setId(UUID.randomUUID());
        entity2.setDocumentNumber("87654321");
        
        when(clientJpaRepository.findAll()).thenReturn(java.util.List.of(entity1, entity2));

        var result = clientJpaAdapter.findAll();

        assertEquals(2, result.size());
    }

    private ClientJpaEntity createTestEntity() {
        ClientJpaEntity entity = new ClientJpaEntity();
        entity.setId(UUID.randomUUID());
        entity.setFirstName("Juan");
        entity.setLastName("Pérez");
        entity.setDocumentType("DNI");
        entity.setDocumentNumber("12345678");
        entity.setEmail("juan@example.com");
        entity.setPhone("+5491112345678");
        entity.setBirthDate(LocalDate.of(1985, 5, 15));
        entity.setMonthlyIncome(new BigDecimal("5000.00"));
        entity.setCreditScore(750);
        return entity;
    }
}