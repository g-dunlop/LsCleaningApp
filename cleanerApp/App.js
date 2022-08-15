import { StatusBar } from 'expo-status-bar';
import {Text, View } from 'react-native';
import Layout from './Styling/Layout';
import ServicesContainer from './Containers/ServicesContainer';

export default function App() {
  return (
    <View style={Layout.container}>
      <Text>CleanerApp</Text>
      <ServicesContainer />
      <StatusBar style="auto"/>
    </View>
  );
}


