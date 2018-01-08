package pl.put.poznan.plantsguard.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.amazonaws.services.glue.model.Predicate;

import pl.put.poznan.plantsguard.model.Configuration;
import pl.put.poznan.plantsguard.model.Device;
import pl.put.poznan.plantsguard.model.DeviceHeader;
import pl.put.poznan.plantsguard.model.DeviceState;

@Service
public class DeviceManager implements IDeviceManager{
	
	private List<Device> deviceList;
	
	private void _generateDevices() {
		Device device = new Device();
		device.setId(1);
		device.setNumber("510243323");
		device.setName("test1");
		device.setConfiguration(new Configuration() {{
			setAuthorizedNumbers(Arrays.asList(new String[]{"11111111","222222222"}));
			setMeasureInterval(50);
			setOrdersInterval(10);
			setNotifyNumber("510243323");
		}});
		device.setLastState(new DeviceState() {{
			setLastBatteryLevel(553.11);
			setLastIrrigateDateTime(LocalDateTime.now());
			setLastMeasureDateTime(LocalDateTime.now());
		}});
		this.deviceList.add(device);
		device = new Device();
		device.setId(2);
		device.setNumber("660234112");
		device.setName("test2");
		device.setConfiguration(new Configuration() {{
			setAuthorizedNumbers(Arrays.asList(new String[]{"66666666","77777777"}));
			setMeasureInterval(50);
			setOrdersInterval(10);
			setNotifyNumber("501554201");
		}});
		device.setLastState(new DeviceState() {{
			setLastBatteryLevel(553.11);
			setLastIrrigateDateTime(LocalDateTime.now());
			setLastMeasureDateTime(LocalDateTime.now());
		}});
		this.deviceList.add(device);
	}
	
	public DeviceManager() {
		this.deviceList = new ArrayList<>();
		_generateDevices();
	}
	
	public Device getDeviceById(Integer id) {
		for(Device device : deviceList) {
			if(device.getId()==id)
				return device;
		}
		return null;		
	}
	
	public void updateDeviceById(Integer id, Device device) {
		ListIterator<Device> it = deviceList.listIterator();
		while(it.hasNext()) {
			Device tmp_device = it.next();
			if(tmp_device.getId()==id)
				tmp_device = device;
		}
	}
	
	public Device getDeviceByNumber(String number) {
		for(Device device : deviceList) {
			if(device.getNumber().equals(number))
				return device;
		}
		return null;
	}
	
	public List<DeviceHeader> getDeviceHeaders() {
		List<DeviceHeader> headers = new ArrayList<>();;
		for(Device device : deviceList ) {
			headers.add(device.getHeader());
		}
		return headers;
	}

	public List<Device> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}

	@Override
	public void addDevice(Device device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDeviceById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	

}
