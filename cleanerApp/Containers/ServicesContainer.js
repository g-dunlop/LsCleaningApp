import { useEffect, useState } from 'react';
import {View, Text, FlatList, TouchableOpacity} from 'react-native';
import ServiceItem from '../Components/ServiceItem';

const ServicesContainer = () => {

    const [services, setServices] = useState([])
    const [isLoading, setIsLoading] = useState(true)

    const getServices = () => {
        fetch('http://192.168.0.12:8080/services')
        // .then(res => console.log(JSON.stringify(res)))
        .then(res => res.json())
        .then(data => setServices(data))
        .catch((error)=> {
            console.log(error)
        })
        setIsLoading(false)
    }

    

    useEffect(()=> {
        getServices()
    }, [])

    const showServices = () => {
        
            return(
                <FlatList
                    scrollEnabled={true}
                    data={services}
                    renderItem={renderServiceItem}
                    keyExtractor={item => item.id}
                />
            )
    }

    const renderServiceItem = ({item}) => {
        return (
            <ServiceItem item={item} />
            
        )
    }

    return (
        <View>
            <View>
                <Text>Service</Text>
            </View>
            <View>
                {isLoading ? null:showServices()}
            </View>
        </View>
    )
}

export default ServicesContainer;