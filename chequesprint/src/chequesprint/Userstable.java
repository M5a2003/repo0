/*
 * Copyright (C) 2015 Administrator
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package chequesprint;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "USERSTABLE", catalog = "", schema = "MUSER")
@NamedQueries({
    @NamedQuery(name = "Userstable.findAll", query = "SELECT u FROM Userstable u"),
    @NamedQuery(name = "Userstable.findByUsername", query = "SELECT u FROM Userstable u WHERE u.username = :username"),
    @NamedQuery(name = "Userstable.findByPassword", query = "SELECT u FROM Userstable u WHERE u.password = :password"),
    @NamedQuery(name = "Userstable.findByUsertype", query = "SELECT u FROM Userstable u WHERE u.usertype = :usertype"),
    @NamedQuery(name = "Userstable.findByEmail", query = "SELECT u FROM Userstable u WHERE u.email = :email")})
public class Userstable implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "USERTYPE")
    private String usertype;
    @Column(name = "EMAIL")
    private String email;

    public Userstable() {
    }

    public Userstable(String username) {
        this.username = username;
    }

    public Userstable(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange(java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("USERNAME"), oldUsername, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange(java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("PASSWORD"), oldPassword, password);
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        String oldUsertype = this.usertype;
        this.usertype = usertype;
        changeSupport.firePropertyChange(java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("USERTYPE"), oldUsertype, usertype);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange(java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("EMAIL"), oldEmail, email);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userstable)) {
            return false;
        }
        Userstable other = (Userstable) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("CHEQUESPRINT.USERSTABLE[ USERNAME={0} ]"), new Object[] {username});
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
