package com.example.meteoapp.endpoints.rest;

import com.example.meteoapp.SpringdatajpaApplication;
import com.example.meteoapp.model.Favorite;
import com.example.meteoapp.model.MunicipioModel;
import com.example.meteoapp.model.ProvinciaModel;
import com.example.meteoapp.model.User;
import com.example.meteoapp.model.WeatherModel;
import com.example.meteoapp.repository.IFavoriteRepository;
import com.example.meteoapp.repository.IUserRepository;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@Controller
public class MeteoAppEndpoint {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	IFavoriteRepository favRepository;

	private ProvinciaModel provinciaModel = new ProvinciaModel();
	private MunicipioModel municipioModel = new MunicipioModel();
	private WeatherModel weatherModel = new WeatherModel();
	private User user;
	private Favorite favorite;
	private List<Favorite> listFavorites;
	private List<String> listCodProv = new ArrayList<>();
	private List<String> listCodIne = new ArrayList<>();
	private List<String> listProvName = new ArrayList<>();
	private List<String> listMunicipName = new ArrayList<>();
	SpringdatajpaApplication springData = new SpringdatajpaApplication();

	@GetMapping("/")
	String home(Model model) {

		if (user != null) {
			provinciaModel.load();
			model.addAttribute("provinces", provinciaModel.getProvObj());
			//System.out.println(provinciaModel.getProvObj());
			model.addAttribute("userName", user.getName());
			return "home";
		} else {
			return "login";
		}
	}

	@GetMapping(value = "/requestCodProv")
	public String getCodMunicip(Model model, @RequestParam(value = "provincia", required = false) String provincia) {
		if (provincia == null) {
			return "home";
		} else {
			municipioModel.load(provincia);
			model.addAttribute("municipios", municipioModel.getMunicipObj());
			return home(model);
		}
	}

	@GetMapping(value = "/requestCodIne")
	public String getWeather(Model model, @RequestParam(value = "provincia", required = false) String provincia,
			@RequestParam(value = "municipio", required = false) String municipio) {
		if (municipio == null) {
			return "home";
		} else {
			if (favRepository.findByIdUserAndCodMunicip(user.getId(), municipio) != null) {
				model.addAttribute("getFav", "notNull");
			} else {
				model.addAttribute("getFav", "null");
			}
			municipio = StringUtils.substring(municipio, 0, 5);
			weatherModel.testJson(provincia, municipio);
			model.addAttribute("weather", weatherModel.getWeatherObj());
			return getCodMunicip(model, provincia);
		}
	}

	@GetMapping("/login")
	String login(Model model) {
		return "login";
	}

	@PostMapping("/loginParams")
	String loginParams(Model model, @RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "password", required = false) String password) {
		if (userRepository.findByEmailAndPassword(email, password) != null) {
			user = userRepository.findByEmailAndPassword(email, password);
			// System.out.println(user.toString());
			return home(model);
		} else {
			model.addAttribute("failMsg", "Email e/ou password incorretos.");
			return "login";
		}
	}

	@GetMapping("/userInfo")
	String userInfo(Model model) {
		model.addAttribute("userInfo", user);
		return "userInfo";
	}

	@GetMapping("/logoff")
	String userLogoff(Model model) {
		user = null;
		return "login";
	}

	@GetMapping("/register")
	String userRegister(Model model) {
		return "register";
	}

	@PostMapping("/registerParams")
	String userRegisterParams(Model model, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "password", required = false) String password) {
		if (userRepository.findByEmail(email) != null) {
			model.addAttribute("emailExists", "Email já se encontra registado.");
		} else {
			userRepository.save(new User(name, email, password));
			model.addAttribute("userSuccess", "Utilizador criado com sucesso.");
		}
		return "register";
	}

	@GetMapping("/favorites")
	String favorites(Model model) {
		listCodProv.clear();
		listCodIne.clear();
		listProvName.clear();
		listMunicipName.clear();
		
		listFavorites = favRepository.findByIdUser(user.getId());
		//System.out.println(listFavorites);
		for (int i = 0; i < listFavorites.size(); i++) {
			listCodProv.add(String.valueOf(listFavorites.get(i).getCodProv()));
			listProvName.add(String.valueOf(listFavorites.get(i).getNameProvincia()));
			listMunicipName.add(String.valueOf(listFavorites.get(i).getNameMunicipio()));
			listCodIne.add(String.valueOf(listFavorites.get(i).getCodMunicip()));
			System.out.println("CodProv: " + listCodProv.get(i) + " --- ProvName: " + listProvName.get(i) + "\nCodIne: " + 
			listCodIne.get(i) + "MunicipName: " + listMunicipName.get(i));
		}
		// TODO - fix ler nomes através de ids
		
		model.addAttribute("listCodProv", listCodProv);
		model.addAttribute("listCodIne", listCodIne);
		model.addAttribute("listProvName", listProvName);
		model.addAttribute("listMunicipName", listMunicipName);
		return "favorites";
	}

	@PostMapping("/addFav")
	String addFavorite(Model model, @RequestParam(value = "provincia", required = false) String provincia,
			@RequestParam(value = "municipio", required = false) String municipio, 
			@RequestParam(value = "nameProvincia", required = false) String nameProvincia,
			@RequestParam(value = "nameMunicipio", required = false) String nameMunicipio) throws UnsupportedEncodingException {
		System.out.println("NAME PROVINCIA: " + nameProvincia + "\nNAME MUNICIPIO: " + nameMunicipio);
		
		favRepository.save(new Favorite(provincia, municipio, user.getId(), URLDecoder.decode(nameProvincia, "UTF-8"), URLDecoder.decode(nameMunicipio, "UTF-8")));
		//return "redirect:/";
		return getWeather(model, provincia, municipio);
	}
	
	@PostMapping("/removeFav")
	String removeFavorite(Model model, @RequestParam(value = "provincia", required = false) String provincia,
			@RequestParam(value = "municipio", required = false) String municipio,
			@RequestParam(value = "favsPage", required = false) String favsPage) {
		
		favorite = favRepository.findByIdUserAndCodMunicip(user.getId(), municipio);
		favRepository.deleteById(favorite.getIdFav());
		
		if (favsPage != null) {
			return favorites(model);
		} else {
			return getWeather(model, provincia, municipio);
		}
		
	}

	String checkAuthUser(Model model) {
		if (user != null) {
			return "test";
		} else {
			return "login";
		}
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		System.out.println("GET USERS");
		System.out.println(userRepository.findAll());
		return (List<User>) userRepository.findAll();
	}

}
