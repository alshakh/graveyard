/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symcode.lab;

import java.util.Set;
import symcode.lab.Property.ConstProperty;
import symcode.lab.Property.EvaluableProperty;
import symcode.lab.Property.NormalProperty;

/**
 * @author Ahmed Alshakh www.alshakh.net
 */
public abstract class Atom extends Molecule {

	/**
	 *
	 * @param id
	 * @param version
	 * @param propertySet
	 * @param constsProperties
	 * @param deps
	 */
	public Atom(String id, String version, Set<NormalProperty> propertySet , Set<ConstProperty> constsProperties, Set<String> deps) {
		super(id, version, propertySet, constsProperties, deps);
	}

	@Override
	public String toString() {
		return "atom " + super.toString();
	}

	/**
	 * do nothing since everything in Atom is covered in Molecule's methods.
	 * @param propertySet 
	 */
	protected void addClassSpecificPropertySet(Set<EvaluableProperty> propertySet) {
		return;
	}
	
}
