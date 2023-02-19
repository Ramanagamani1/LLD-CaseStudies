package controllers;

import dtos.*;
import models.ParkingFloor;
import models.ParkingLot;
import services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotController {

    public ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
       this.parkingLotService = parkingLotService;
    }

    public CreateParkingLotResponseDto createParkingLot(CreateParkingLotRequestDto requestDto) {
        if(requestDto.getNumberOfFloors() < 2) {
            CreateParkingLotResponseDto responseDto = new CreateParkingLotResponseDto();
            responseDto.setResponseStatusDto(ResponseStatusDto.FAILURE);
            return responseDto;
        }
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress(requestDto.getAddress());

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i=0;i<requestDto.getNumberOfFloors();i++) {
            parkingFloors.add(new ParkingFloor());
        }
        parkingLot.setParkingFloors(parkingFloors);

        ParkingLot createdParkingLot = parkingLotService.createParkingLot(parkingLot);

        CreateParkingLotResponseDto responseDto = new CreateParkingLotResponseDto();
        responseDto.setParkingLot(createdParkingLot);
        responseDto.setResponseStatusDto(ResponseStatusDto.SUCCESS);
        return responseDto;
    }

    public UpdateParkingLotResponseDto updateAddress(UpdateParkingLotRequestDto request) {
           ParkingLot updatedParkingLot = parkingLotService.updateAddress(request.getParkingLotId(),request.getAddress());
           UpdateParkingLotResponseDto responseDto = new UpdateParkingLotResponseDto();
           responseDto.setParkingLot(updatedParkingLot);
           responseDto.setResponseStatusDto(ResponseStatusDto.SUCCESS);
           return responseDto;
    }
}
