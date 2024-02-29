package api.dentiste.apidentiste.service.ServiceImplement;

import api.dentiste.apidentiste.dto.AppointmentDto;
import api.dentiste.apidentiste.entity.Appointment;
import api.dentiste.apidentiste.mapper.AppointmentsMapper;
import api.dentiste.apidentiste.mapper.AppointmentsMapperImpl;
import api.dentiste.apidentiste.repository.AppointmentRepository;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppointmentImplTest {
    @InjectMocks
   private  AppointmentImpl appointment;


 @Test
    void addAppointment() {
     AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);

     // Création d'un mock pour l'objet AppointmentMapper
     AppointmentsMapper appointmentMapper = mock(AppointmentsMapper.class);
     AppointmentDto appointmentDto = new AppointmentDto();
     appointmentDto.setId(1L);

     Appointment appointmentEntity = new Appointment();
     appointmentEntity.setId(1L);

     // Simuler le comportement du mapper pour retourner l'entité fictive
     when(appointmentMapper.transformaDtoToEntity(any(AppointmentDto.class))).thenReturn(appointmentEntity);

     // Création d'un objet AppointmentService en lui passant les mocks en paramètres
     AppointmentImpl appointmentService = new AppointmentImpl(appointmentMapper,appointmentRepository);

     // Appel de la méthode addAppointment avec l'objet fictif
     appointmentService.addAppointment(appointmentDto);

     // Utilisation de Mockito pour capturer l'argument passé à la méthode save du mock AppointmentRepository
     ArgumentCaptor<Appointment> captor = ArgumentCaptor.forClass(Appointment.class);
     verify(appointmentRepository).save(captor.capture());

     // Vérification que l'argument capturé correspond bien à l'objet transformé par le mapper
     Appointment capturedEntity = captor.getValue();

     assertEquals(appointmentDto.getId(), capturedEntity.getId());
     assertEquals(appointmentDto.getDate(), capturedEntity.getDate());

    }



    @Test
    void updateAppointment() {
     AppointmentRepository  appointmentRepository = mock(AppointmentRepository.class);
     AppointmentsMapper appointmentsMapper = mock(AppointmentsMapper.class);

     AppointmentDto appointmentDto = new AppointmentDto();
     appointmentDto.setId(1L);

     Appointment appointmentEntity = new Appointment();
     appointmentEntity.setId(1L);
     // Création d'un objet AppointmentService en lui passant les mocks en paramètres
     AppointmentImpl appointmentService = new AppointmentImpl(appointmentsMapper,appointmentRepository);

     // Simuler le comportement du mapper pour retourner l'entité fictive
     when(appointmentsMapper.transformaDtoToEntity(any(AppointmentDto.class))).thenReturn(appointmentEntity);
     when(appointmentRepository.existsById(appointmentEntity.getId())).thenReturn(true);
     appointmentService.updateAppointment(appointmentDto);

     ArgumentCaptor<Appointment> captor = ArgumentCaptor.forClass(Appointment.class);
     verify(appointmentRepository).existsById(appointmentEntity.getId());
     verify(appointmentRepository).save(captor.capture());

     // Vérification que l'argument capturé correspond bien à l'objet transformé par le mapper
     Appointment capturedEntity = captor.getValue();

     assertEquals(appointmentDto.getId(), capturedEntity.getId());
     assertEquals(appointmentDto.getDate(), capturedEntity.getDate());

    }

    @Test
    void getListAppointment() {
     AppointmentRepository  appointmentRepository = mock(AppointmentRepository.class);
     AppointmentsMapper appointmentsMapper = mock(AppointmentsMapper.class);

     List<AppointmentDto> appointmentDtoList = new ArrayList<>();
     AppointmentDto appointmentDto = new AppointmentDto();
     appointmentDto.setId(1L);
     appointmentDtoList.add(appointmentDto);
     Appointment appointmentEntity = new Appointment();
     appointmentEntity.setId(1L);
     List<Appointment> appointmentList = new ArrayList<>();
     appointmentList.add(appointmentEntity);
     // Création d'un objet AppointmentService en lui passant les mocks en paramètres
     AppointmentImpl appointmentService = new AppointmentImpl(appointmentsMapper,appointmentRepository);
    //le mock des differente methode
     when(appointmentRepository.findAll()).thenReturn(appointmentList);
     when(appointmentsMapper.listtoRendezVousDto(appointmentList)).thenReturn(appointmentDtoList);

     List<AppointmentDto> result = appointmentService.getListAppointment();

     verify(appointmentRepository).findAll();
     verify(appointmentsMapper).listtoRendezVousDto(appointmentList);

     assertEquals(appointmentDtoList, result);
    }

    @Test
    void deleteAppointment() {
     AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
     AppointmentsMapper appointmentsMapper = mock(AppointmentsMapper.class);
     Appointment appointment = new Appointment();
     AppointmentDto appointmentDto =new AppointmentDto();

     AppointmentImpl appointmentService = new AppointmentImpl(appointmentsMapper,appointmentRepository);
     when(appointmentRepository.existsById(any(Long.class))).thenReturn(true);

     appointmentService.deleteAppointment(any(Long.class));
     verify(appointmentRepository).existsById(any(Long.class));
    }

    @Test
    void searchAppointmentByDate() {
     AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
     AppointmentsMapper appointmentsMapper = mock(AppointmentsMapper.class);
     Appointment appointment = new Appointment();
     appointment.setId(1L);
     AppointmentDto appointmentDto =new AppointmentDto();

     AppointmentImpl appointmentService = new AppointmentImpl(appointmentsMapper,appointmentRepository);
     //le mock des differente methode
     List<Appointment> appointmentList = new ArrayList<>();
     List<AppointmentDto> appointmentDtoList = new ArrayList<>();
     appointmentList.add(appointment);

     appointmentDto.setId(1L);
     appointmentDtoList.add(appointmentDto);

     when(appointmentRepository.searchAppointmentByDate(new Date())).thenReturn(appointmentList);
     when(appointmentsMapper.listtoRendezVousDto(appointmentList)).thenReturn(appointmentDtoList);
     List<AppointmentDto> result = appointmentService.searchAppointmentByDate(new Date());
//     verify(appointmentRepository).searchAppointmentByDate(new Date());
//     verify(appointmentsMapper).listtoRendezVousDto(appointmentList);
     ArgumentCaptor<Appointment> captor = ArgumentCaptor.forClass(Appointment.class);
     assertEquals(appointmentDtoList, result);
    }

    @Test
    void searchAppointmentByUser() {
    }

    @Test
    void testAddAppointment() {
    }

    @Test
    void testUpdateAppointment() {
    }

    @Test
    void testGetListAppointment() {
    }

    @Test
    void testDeleteAppointment() {
    }

    @Test
    void testSearchAppointmentByDate() {
    }

    @Test
    void testSearchAppointmentByUser() {
    }
}