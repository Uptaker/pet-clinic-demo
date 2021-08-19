package codes.drinky.petclinicdemo.controllers;

import codes.drinky.petclinicdemo.model.Owner;
import codes.drinky.petclinicdemo.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1l).build());
        owners.add(Owner.builder().id(2l).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(ownerController)
                .build();
    }

//    @Test
//    void listOwners() throws Exception {
//        when(ownerService.findAll()).thenReturn(owners);
//        mockMvc.perform(get("/owners"))
//                .andExpect(status().isOk())
//        .andExpect(view().name("owners/index"))
//        .andExpect(model().attribute("owners", hasSize(2)));
//    }
//
//    @Test
//    void findOwner() throws Exception {
//        mockMvc.perform(get("/owners/find"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("notImplemented"));
//
//        verifyZeroInteractions(ownerService);
//    }
}