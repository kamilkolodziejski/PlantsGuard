package pl.put.poznan.plantsguard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import pl.put.poznan.plantsguard.model.Device;
import pl.put.poznan.plantsguard.model.DeviceHeader;

public interface IDeviceManager {

	public void addDevice(Device device);
	public Device getDeviceById(Integer id);
	public void updateDeviceById(Integer id, Device device);
	public void removeDeviceById(Integer id);

	public Device getDeviceByNumber(String number);

	public List<DeviceHeader> getDeviceHeaders();
}
