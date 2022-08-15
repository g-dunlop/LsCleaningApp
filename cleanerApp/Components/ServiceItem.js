import { TouchableOpacity, Text } from "react-native";


const ServiceItem = (props) => {

    
    return(
    <TouchableOpacity>
        <Text>{props.item.name}</Text>
        <Text>${props.item.price}</Text>
    </TouchableOpacity>

)
    }

export default ServiceItem;